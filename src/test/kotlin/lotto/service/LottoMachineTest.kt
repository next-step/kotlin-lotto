package lotto.service

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.Lottos
import lotto.domain.WinningLotto
import lotto.vo.WinningLottoPrizeVO
import java.math.BigDecimal
import java.math.RoundingMode

class LottoMachineTest : FunSpec({

    test("당첨 로또 상금 매칭 결과를 반환한다") {
        val winningLotto = Lotto(1, 2, 3, 7, 8, 10)
        val secondPrizeLotto = Lotto(1, 2, 3, 7, 8, 9)
        val thirdPrizeLotto = Lotto(1, 2, 3, 7, 8, 11)
        val fourthPrizeLotto = Lotto(1, 2, 3, 7, 5, 6)
        val missPrizeLotto = Lotto(1, 2, 4, 5, 6, 9)
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
        val lottoMachine = LottoMachine(lottos)

        val winningLottoPrizeVOs = lottoMachine.matchWinningLottoPrize(WinningLotto(winningLotto, LottoNumber(9)))
        winningLottoPrizeVOs[0] shouldBe WinningLottoPrizeVO(3, BigDecimal(5_000), 0, false)
        winningLottoPrizeVOs[1] shouldBe WinningLottoPrizeVO(4, BigDecimal(50_000), 3, false)
        winningLottoPrizeVOs[2] shouldBe WinningLottoPrizeVO(5, BigDecimal(1_500_000), 1, false)
        winningLottoPrizeVOs[3] shouldBe WinningLottoPrizeVO(5, BigDecimal(30_000_000), 1, true)
        winningLottoPrizeVOs[4] shouldBe WinningLottoPrizeVO(6, BigDecimal(2_000_000_000), 1, false)
    }

    test("총 수익률을 반환한다") {
        val winningLotto = Lotto(1, 2, 3, 7, 8, 10)
        val secondPrizeLotto = Lotto(1, 2, 3, 7, 8, 9)
        val thirdPrizeLotto = Lotto(1, 2, 3, 7, 8, 11)
        val fourthPrizeLotto = Lotto(1, 2, 3, 7, 5, 6)
        val fifthPrizeLotto = Lotto(1, 2, 3, 4, 5, 6)
        val missPrizeLotto = Lotto(1, 2, 4, 5, 6, 9)
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
        val lottoMachine = LottoMachine(lottos)

        val totalProfitRate = lottoMachine.getTotalProfitRate(WinningLotto(winningLotto, LottoNumber(9)))

        totalProfitRate shouldBe BigDecimal(338592.50).setScale(2, RoundingMode.HALF_UP)
    }
})
