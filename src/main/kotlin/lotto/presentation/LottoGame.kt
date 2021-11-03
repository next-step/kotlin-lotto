package lotto.presentation

import lotto.domain.BonusNumber
import lotto.domain.Lotto
import lotto.domain.LottoStatistics
import lotto.domain.WinningNumber
import lotto.domain.WinningNumbers
import lotto.usecase.LottoMachine
import lotto.usecase.PurchaseAmountCalculator
import lotto.usecase.WinningsChecker

class LottoGame(
    private val lottoMachine: LottoMachine,
    private val winningsChecker: WinningsChecker,
    private val calculator: PurchaseAmountCalculator,
) {

    fun buy(purchaseAmount: Int): List<Lotto> {
        return lottoMachine.buy(purchaseAmount)
    }

    fun statistics(
        winningNumbers: List<Int>,
        lottos: List<Lotto>,
        bonusNumber: Int,
    ): LottoStatistics {
        val winningNumber = WinningNumber(
            WinningNumbers(winningNumbers),
            BonusNumber(bonusNumber)
        )
        val winningStatistics = winningsChecker.confirmWinning(
            lottos = lottos,
            winningNumber = winningNumber
        )

        return LottoStatistics(
            totalPurchaseAmount = calculator.getTotalPurchaseAmount(lottos),
            winningStatistics = winningStatistics
        )
    }
}
