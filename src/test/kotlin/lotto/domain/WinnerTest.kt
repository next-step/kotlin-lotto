package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class WinnerTest : StringSpec({
    val winningLotto = LottoMachine.generateLotto(listOf(1, 2, 3, 4, 5, 6))
    val bonusNumber = LottoNumber.from(7)
    val winner = Winner(winningLotto, bonusNumber)

    "보너스 볼은 지난주 당첨 번호와 중복되지 않아야 한다." {
        shouldThrow<IllegalArgumentException> {
            Winner(
                winningLotto = winningLotto,
                bonusLottoNumber = LottoNumber.from(1)
            )
        }
    }

    "일치 갯수에 따라 수익률 계산 하다." {
        val matchReward = mapOf(
            Reward.FIVE_PLACE to 1,
            Reward.FOURTH_PLACE to 0,
            Reward.THIRD_PLACE to 0,
            Reward.FIST_PLACE to 0,
        )

        forAll(
            row(14, 0.36),
            row(10, 0.5),
        ) { purchaseCount, incomeRate ->
            val actualIncomeRate = winner.getIncomeRate(purchaseCount, matchReward)

            val formattedActual = String.format("%.2f", actualIncomeRate)
            val formattedExpect = String.format("%.2f", incomeRate)

            formattedActual shouldBe formattedExpect
        }
    }

    "5숫자가 일치할 경우, 보너스 번호 유무도 확인한다." {
        forAll(
            row(listOf(LottoMachine.generateLotto(listOf(1, 2, 3, 4, 7, 8))), true),
            row(listOf(LottoMachine.generateLotto(listOf(3, 4, 5, 6, 7, 20))), true),
            row(listOf(LottoMachine.generateLotto(listOf(11, 12, 13, 14, 15, 16))), false),
        ) { lottoList, matchBonus ->
            val matchResult: Map<Reward, Int> = winner.match(lottoList)
            val hasBonus: Boolean = matchResult.any { (reward, matchCount) ->
                reward.hasBonus && reward.matchCount == 5 && matchCount > 0
            }

            hasBonus shouldBe matchBonus
        }
    }
})
