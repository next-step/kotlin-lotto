package lotto

import lotto.agency.LottoJudge
import lotto.seller.LottoSeller
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val inputView = InputView()
    val money = inputView.enterMoney()

    val lottoSeller = LottoSeller()
    val lottoPurchaseAmount = lottoSeller.calculateLottoPurchaseAmount(money)
    val lottoTickets = lottoSeller.buy(lottoPurchaseAmount)

    val wonLottoTicket = inputView.enterWonLottoTicket()
    val bonusLottoNumber = inputView.enterBonusLottoNumber(wonLottoTicket)
    val lottoJudge = LottoJudge()
    val determinedLottoTicket = lottoJudge.determineLottoWinnings(lottoTickets, wonLottoTicket, bonusLottoNumber)

    val resultView = ResultView()
    resultView.printPurchaseAmount(lottoPurchaseAmount)
    resultView.printPurchaseLottoTickets(lottoTickets)
    resultView.printWinningStatistics(determinedLottoTicket, money)
}
