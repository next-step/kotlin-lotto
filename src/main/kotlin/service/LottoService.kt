package service

import domain.Lotto
import domain.LottoPurchaseInfo
import domain.LottoShuffler
import domain.LottoTicket
import domain.ProfitCalculator
import domain.WinningResult

class LottoService(
    private val profitCalculator: ProfitCalculator = ProfitCalculator(),
) {
    fun purchaseLottoTicket(lottoPurchaseInfo: LottoPurchaseInfo): LottoTicket {
        val automaticLotto = List(lottoPurchaseInfo.calculateAutoLottoCount()) { LottoShuffler.generateAutomaticLotto() }
        return LottoTicket(lottoPurchaseInfo.manualLottoNumbers + automaticLotto)
    }

    fun getWinningResult(
        lottoTicket: LottoTicket,
        winningLotto: Lotto,
        purchaseLottoAmount: Int,
    ): WinningResult {
        val winningCountMap =
            lottoTicket.lottos
                .map { it.determineWinningType(winningLotto) }
                .groupingBy { it }
                .eachCount()
                .withDefault { 0 }
        val profit = profitCalculator.calculateProfit(winningCountMap, purchaseLottoAmount)
        return WinningResult(winningCountMap, profit)
    }
}
