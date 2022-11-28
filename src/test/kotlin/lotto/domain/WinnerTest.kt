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

    "5숫자가 일치할 경우, 보너스 번호 유무도 확인한다." {
        forAll(
            row(listOf(LottoMachine.generateLotto(listOf(1, 2, 3, 4, 7, 8))), true),
            row(listOf(LottoMachine.generateLotto(listOf(3, 4, 5, 6, 7, 20))), true),
            row(listOf(LottoMachine.generateLotto(listOf(11, 12, 13, 14, 15, 16))), false),
        ) { lottoList, matchBonus ->
            val rank: Rank = winner.match(lottoList)
            val hasBonus: Boolean = rank.matchReward.any { (reward, matchCount) ->
                reward.hasBonus && reward.matchCount == 5 && matchCount > 0
            }

            hasBonus shouldBe matchBonus
        }
    }
})
