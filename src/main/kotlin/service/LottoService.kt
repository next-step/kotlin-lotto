package service

import domain.lotto.LottoTicket
import domain.purchase.LottoPurchaseInfo
import domain.winning.WinningLotto
import domain.winning.WinningResult

class LottoService(
    private val profitCalculator: ProfitCalculator,
    private val automaticLottoGenerateService: AutomaticLottoGenerateService,
) {
    fun purchaseLottoTicket(lottoPurchaseInfo: LottoPurchaseInfo): LottoTicket {
        val automaticLotto =
            List(lottoPurchaseInfo.autoLottoCount) { automaticLottoGenerateService.generateAutomaticLotto() }
        return LottoTicket(lottoPurchaseInfo.manualLottoNumbers + automaticLotto)
    }

    fun getWinningResult(
        lottoTicket: LottoTicket,
        winningLotto: WinningLotto,
        purchaseLottoAmount: Int,
    ): WinningResult {
        val winningCountMap =
            lottoTicket.lottos
                .map { winningLotto.determineWinningType(it) }
                .groupingBy { it }
                .eachCount()
                .withDefault { 0 }
        val profit = profitCalculator.calculateProfit(winningCountMap, purchaseLottoAmount)
        return WinningResult(winningCountMap, profit)
    }
}
