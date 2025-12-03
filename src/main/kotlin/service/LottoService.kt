package service

import domain.lotto.Lotto
import domain.lotto.LottoNumber
import domain.lotto.LottoTicket
import domain.purchase.LottoPurchaseInfo
import domain.winning.WinningResult

class LottoService(
    private val profitCalculator: ProfitCalculator,
    private val automaticLottoGenerateService: AutomaticLottoGenerateService,
) {
    fun purchaseLottoTicket(lottoPurchaseInfo: LottoPurchaseInfo): LottoTicket {
        val automaticLotto =
            List(lottoPurchaseInfo.calculateAutoLottoCount()) { automaticLottoGenerateService.generateAutomaticLotto() }
        return LottoTicket(lottoPurchaseInfo.manualLottoNumbers + automaticLotto)
    }

    fun getWinningResult(
        lottoTicket: LottoTicket,
        winningLotto: Lotto,
        bonusNumber: LottoNumber,
        purchaseLottoAmount: Int,
    ): WinningResult {
        val winningCountMap =
            lottoTicket.lottos
                .map { it.determineWinningType(winningLotto, bonusNumber) }
                .groupingBy { it }
                .eachCount()
                .withDefault { 0 }
        val profit = profitCalculator.calculateProfit(winningCountMap, purchaseLottoAmount)
        return WinningResult(winningCountMap, profit)
    }
}
