package lotto.controller

import lotto.domain.LotteryTickets
import lotto.domain.LotteryTicketsOrderRequest
import lotto.domain.LottoNumber
import lotto.domain.LottoStore
import lotto.domain.PurchaseLotteryTicketResult
import lotto.domain.WinningLottoNumber
import lotto.domain.util.WinningStatisticsGenerator
import lotto.view.LottoInputView
import lotto.view.LottoResultView

class LottoController(
    private val lottoInputView: LottoInputView,
    private val lottoResultView: LottoResultView,
    private val lottoStore: LottoStore,
) {

    fun purchaseLotteryTickets(): PurchaseLotteryTicketResult {
        val purchaseAmount = lottoInputView.readPurchaseAmount()
        val manualLotteryTicketCount = lottoInputView.readManualLotteryTicketCount()
        val manualLottoNumbers = lottoInputView.readManualLottoNumbers(manualLotteryTicketCount)
        val request = LotteryTicketsOrderRequest(purchaseAmount = purchaseAmount, manualLottoNumbers = manualLottoNumbers)
        return lottoStore.purchase(request)
    }

    fun printLotteryTickets(purchasedLotteryTickets: PurchaseLotteryTicketResult.SUCCESS) {
        lottoResultView.printLotteryTickets(purchasedLotteryTickets)
    }

    fun readWinningLottoNumber(): WinningLottoNumber {
        val lastWinLottoNumber = lottoInputView.readLastWeekWinningLottoNumbers()
        val bonusLottoNumber = LottoNumber(lottoInputView.readBonusBallNumber())
        return WinningLottoNumber(winningNumbers = lastWinLottoNumber, bonusLottoNumber = bonusLottoNumber)
    }

    fun printLottoResult(lotteryTickets: LotteryTickets, winningLottoNumber: WinningLottoNumber) {
        val rankingCountMap = WinningStatisticsGenerator.getRankingCountStatistics(
            lotteryTickets = lotteryTickets,
            winningLottoNumber = winningLottoNumber
        )
        val totalRevenueRate = WinningStatisticsGenerator.getRevenueRateStatistics(
            lotteryTickets = lotteryTickets,
            winningLottoNumber = winningLottoNumber
        )
        lottoResultView.printLottoStatistics(rankingCountMap = rankingCountMap, totalRevenueRate = totalRevenueRate)
    }
}
