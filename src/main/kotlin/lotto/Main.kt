package lotto

import lotto.agency.LottoJudge
import lotto.agency.number.LottoNumberMaker
import lotto.seller.LottoSeller
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val inputView = InputView()
    val money = inputView.enterMoney()

    val lottoSeller = LottoSeller()
    val lottoPurchaseAmount = lottoSeller.calculateLottoPurchaseAmount(money)
    val lottoNumberMaker = LottoNumberMaker()
    val lottoTickets = lottoSeller.buy(lottoPurchaseAmount, lottoNumberMaker)

    val wonLottoTicket = inputView.enterWonLottoTicket()
    val lottoJudge = LottoJudge()
    val determinedLottoTicket = lottoJudge.determineLottoWinnings(lottoTickets, wonLottoTicket)

    val resultView = ResultView()
    resultView.printPurchaseAmount(lottoPurchaseAmount)
    resultView.printPurchaseLottoTickets(lottoTickets)
    resultView.printWinningStatistics(determinedLottoTicket, money)
}
