package lotto.controller

import lotto.domain.LotteryTickets
import lotto.domain.LottoNumber
import lotto.domain.LottoStore
import lotto.domain.WinningLottoNumber
import lotto.view.LottoInputView
import lotto.view.LottoResultView

class LottoController(
    private val lottoInputView: LottoInputView,
    private val lottoResultView: LottoResultView,
    private val lottoStore: LottoStore,
) {

    fun purchaseLotteryTickets(): LotteryTickets {
        val purchaseAmount = lottoInputView.readPurchaseAmount()
        val manualLotteryTicketCount = lottoInputView.readManualLotteryTicketCount()
        val manualLottoNumbers = lottoInputView.readManualLottoNumbers(manualLotteryTicketCount)
        return lottoStore.purchase(purchaseAmount, manualLottoNumbers)
    }

    fun printLotteryTickets(lotteryTickets: LotteryTickets) {
        val (autos, manuals) = lotteryTickets.partition { it.isAuto }
        val autoLotteryTickets = LotteryTickets(autos)
        val manualLotteryTickets = LotteryTickets(manuals)
        lottoResultView.printLotteryTickets(manualLotteryTickets = manualLotteryTickets, autoLotteryTickets = autoLotteryTickets)
    }

    fun readWinningLottoNumber(): WinningLottoNumber {
        val lastWinLottoNumber = lottoInputView.readLastWeekWinningLottoNumbers()
        val bonusLottoNumber = LottoNumber(lottoInputView.readBonusBallNumber())
        return WinningLottoNumber(winningNumbers = lastWinLottoNumber, bonusLottoNumber = bonusLottoNumber)
    }

    fun printLottoResult(lotteryTickets: LotteryTickets, winningLottoNumber: WinningLottoNumber) {
        val rankingCountMap = winningLottoNumber.makeRankingCountMap(lotteryTickets)
        val totalRevenueRate = winningLottoNumber.getRevenueRate(lotteryTickets)
        lottoResultView.printLottoStatistics(rankingCountMap = rankingCountMap, totalRevenueRate = totalRevenueRate)
    }
}
