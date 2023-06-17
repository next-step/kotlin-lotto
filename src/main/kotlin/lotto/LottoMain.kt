package lotto

import lotto.domain.LotteryTickets
import lotto.domain.LottoNumber
import lotto.domain.LottoStore
import lotto.domain.WinningLottoNumber
import lotto.view.LottoInputView
import lotto.view.LottoResultView

fun main() {
    val lottoInputView = LottoInputView()
    val lottoResultView = LottoResultView()
    val lottoStore = LottoStore()

    val purchaseAmount = lottoInputView.readPurchaseAmount()
    val manualLotteryTicketCount = lottoInputView.readManualLotteryTicketCount()
    val manualLottoNumbers = lottoInputView.readManualLottoNumbers(manualLotteryTicketCount)
    val lotteryTickets = lottoStore.purchase(purchaseAmount, manualLottoNumbers)

    val (autos, manuals) = lotteryTickets.partition { it.isAuto }
    val autoLotteryTickets = LotteryTickets(autos)
    val manualLotteryTickets = LotteryTickets(manuals)
    lottoResultView.printLotteryTickets(manualLotteryTickets = manualLotteryTickets, autoLotteryTickets = autoLotteryTickets)

    val lastWinLottoNumber = lottoInputView.readLastWeekWinningLottoNumbers()
    val bonusLottoNumber = LottoNumber(lottoInputView.readBonusBallNumber())
    val winningLottoNumber = WinningLottoNumber(winningNumbers = lastWinLottoNumber, bonusLottoNumber = bonusLottoNumber)

    val rankingCountMap = winningLottoNumber.makeRankingCountMap(lotteryTickets)
    val totalRevenueRate = winningLottoNumber.getRevenueRate(lotteryTickets)
    lottoResultView.printLottoStatistics(rankingCountMap = rankingCountMap, totalRevenueRate = totalRevenueRate)
}
