package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import java.math.BigDecimal

class PrizeTest : StringSpec({
    "총 상금액을 계산한다" {
        val winningLotto = Lotto.of(listOf(1, 2, 3, 7, 8, 10))
        val secondPrizeLotto = Lotto.of(listOf(1, 2, 3, 7, 8, 9))
        val thirdPrizeLotto = Lotto.of(listOf(1, 2, 6, 7, 8, 9))
        val fourthPrizeLotto = Lotto.of(listOf(1, 2, 3, 4, 5, 6))
        val nonePrizeLotto = Lotto.of(listOf(1, 2, 4, 5, 6, 9))

        val totalPrizeAmount: BigDecimal = Prize.calculateTotalPrizeAmount(
            lottos = Lottos(listOf(winningLotto, secondPrizeLotto, thirdPrizeLotto, fourthPrizeLotto, nonePrizeLotto)),
            winningLotto = winningLotto,
        )

        totalPrizeAmount shouldBe BigDecimal(200_1_555_000)
    }

    "상금별로 당첨 로또 횟수를 구한다" {
        val winningLotto = Lotto.of(listOf(1, 2, 3, 7, 8, 10))
        val secondPrizeLotto = Lotto.of(listOf(1, 2, 3, 7, 8, 9))
        val thirdPrizeLotto = Lotto.of(listOf(1, 2, 6, 7, 8, 9))
        val fourthPrizeLotto = Lotto.of(listOf(1, 2, 3, 4, 5, 6))
        val nonePrizeLotto = Lotto.of(listOf(1, 2, 4, 5, 6, 9))

        val winningLottoCountsByPrize = Prize.getWinningLottoCountsByPrize(
            lottos = Lottos(
                listOf(
                    winningLotto,
                    secondPrizeLotto,
                    thirdPrizeLotto,
                    fourthPrizeLotto,
                    fourthPrizeLotto,
                    fourthPrizeLotto,
                    nonePrizeLotto
                )
            ),
            winningLotto = winningLotto,
        )

        winningLottoCountsByPrize[Prize.FIRST] shouldBe 1
        winningLottoCountsByPrize[Prize.SECOND] shouldBe 1
        winningLottoCountsByPrize[Prize.THIRD] shouldBe 1
        winningLottoCountsByPrize[Prize.FOURTH] shouldBe 3
    }
})
