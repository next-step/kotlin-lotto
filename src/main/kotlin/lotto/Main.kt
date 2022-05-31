package lotto

import lotto.agency.LottoJudge
import lotto.agency.number.LottoNumberMaker
import lotto.seller.LottoSeller
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val inputView = InputView()
    val money = inputView.enterMoney()
    val manualLottoPurchaseAmount = inputView.enterManualLottoPurchaseAmount()
    val manualLottoNumbers = inputView.enterManualLottoTicket(manualLottoPurchaseAmount)

    val lottoSeller = LottoSeller()
    val autoLottoPurchaseAmount = lottoSeller.calculateAutoLottoPurchaseAmount(money, manualLottoPurchaseAmount)
    val autoLottoNumberMaker = LottoNumberMaker()
    val purchasedLottoTickets = lottoSeller.buy(autoLottoPurchaseAmount, manualLottoNumbers, autoLottoNumberMaker)

    val wonLottoTicket = inputView.enterWonLottoTicket()
    val lottoJudge = LottoJudge()
    val determinedLottoTicket = lottoJudge.determineLottoWinnings(purchasedLottoTickets, wonLottoTicket)

    val resultView = ResultView()
    resultView.printPurchaseAmount(manualLottoPurchaseAmount, autoLottoPurchaseAmount)
    resultView.printPurchaseLottoTickets(purchasedLottoTickets)
    resultView.printWinningStatistics(determinedLottoTicket, money)
}
