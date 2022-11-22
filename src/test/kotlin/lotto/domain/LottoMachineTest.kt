package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe

class LottoMachineTest : StringSpec({
    "6숫자를 입력하면 로또를 생성한다." {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val lotto = LottoMachine.generateLotto(numbers)

        lotto.lottoNumbers shouldHaveSize 6
    }

    "1,000 미만으로 로또 구입할땐 예외가 발생한다." {
        val amount = 10

        shouldThrow<IllegalArgumentException> {
            LottoMachine.getLottoList(amount)
        }
    }

    "로또 한장의 가격은 1,000 원이다." {
        forAll(
            row(1_000, 1),
            row(12_000, 12),
            row(14_000, 14),
        ) { amount, lottoCount ->
            LottoMachine.getLottoList(amount) shouldHaveSize lottoCount
        }
    }

    "일치 갯수에 따라 수익률 계산 하다." {
        val matchReward = mapOf(
            Reward.MATCH_THREE to 1,
            Reward.MATCH_FOUR to 0,
            Reward.MATCH_FIV to 0,
            Reward.MATCH_SIX to 0,
        )

        forAll(
            row(14, 0.36),
            row(10, 0.5),
        ) { purchaseCount, incomeRate ->
            val actualIncomeRate = LottoMachine.getIncomeRate(purchaseCount, matchReward)

            val formattedActual = String.format("%.2f", actualIncomeRate)
            val formattedExpect = String.format("%.2f", incomeRate)

            formattedActual shouldBe formattedExpect
        }
    }
})
