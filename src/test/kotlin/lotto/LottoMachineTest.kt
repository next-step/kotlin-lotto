package lotto

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import java.math.BigDecimal
import java.math.RoundingMode

class LottoMachineTest : FunSpec({

    test("당첨 로또 상금 매칭 결과를 반환한다") {
        val winningLotto = Lotto.of(listOf(1, 2, 3, 7, 8, 10))
        val secondPrizeLotto = Lotto.of(listOf(1, 2, 3, 7, 8, 9))
        val thirdPrizeLotto = Lotto.of(listOf(1, 2, 3, 7, 8, 11))
        val fourthPrizeLotto = Lotto.of(listOf(1, 2, 3, 7, 5, 6))
        val missPrizeLotto = Lotto.of(listOf(1, 2, 4, 5, 6, 9))
        val lottos = Lottos(
            listOf(
                winningLotto,
                secondPrizeLotto,
                thirdPrizeLotto,
                fourthPrizeLotto,
                fourthPrizeLotto,
                fourthPrizeLotto,
                missPrizeLotto
            )
        )
        val lottoMachine = LottoMachine(lottos, WinningLotto(winningLotto, LottoNumber(9)))

        val winningLottoPrizeVOs = lottoMachine.matchWinningLottoPrize()
        winningLottoPrizeVOs[0] shouldBe WinningLottoPrizeVO(3, BigDecimal(5_000), 0, false)
        winningLottoPrizeVOs[1] shouldBe WinningLottoPrizeVO(4, BigDecimal(50_000), 3, false)
        winningLottoPrizeVOs[2] shouldBe WinningLottoPrizeVO(5, BigDecimal(1_500_000), 1, false)
        winningLottoPrizeVOs[3] shouldBe WinningLottoPrizeVO(5, BigDecimal(30_000_000), 1, true)
        winningLottoPrizeVOs[4] shouldBe WinningLottoPrizeVO(6, BigDecimal(2_000_000_000), 1, false)
    }

    test("총 수익률을 반환한다") {
        val winningLotto = Lotto.of(listOf(1, 2, 3, 7, 8, 10))
        val secondPrizeLotto = Lotto.of(listOf(1, 2, 3, 7, 8, 9))
        val thirdPrizeLotto = Lotto.of(listOf(1, 2, 3, 7, 8, 11))
        val fourthPrizeLotto = Lotto.of(listOf(1, 2, 3, 7, 5, 6))
        val fifthPrizeLotto = Lotto.of(listOf(1, 2, 3, 4, 5, 6))
        val missPrizeLotto = Lotto.of(listOf(1, 2, 4, 5, 6, 9))
        val lottos = Lottos(
            listOf(
                winningLotto,
                secondPrizeLotto,
                thirdPrizeLotto,
                fourthPrizeLotto,
                fifthPrizeLotto,
                missPrizeLotto
            )
        )
        val lottoMachine = LottoMachine(lottos, WinningLotto(winningLotto, LottoNumber(9)))

        val totalProfitRate = lottoMachine.getTotalProfitRate()

        totalProfitRate shouldBe BigDecimal(338592.50).setScale(2, RoundingMode.HALF_UP)
    }
})
