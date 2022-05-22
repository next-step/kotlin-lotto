package lotto

import lotto.agency.LottoJudge
import lotto.seller.LottoSeller
import lotto.validation.LottoValidate
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val inputView = InputView()
    val text = inputView.printEnterMoney()

    val lottoValidate = LottoValidate()
    lottoValidate.validatePurchase(text)

    val money = text.toInt()
    val lottoSeller = LottoSeller()
    val lottoPurchaseAmount = lottoSeller.calculateLottoPurchaseAmount(money)
    val lottoTickets = lottoSeller.sell(lottoPurchaseAmount)

    val wonLottoLastWeek = inputView.printEnterWonLottoLastWeek()
    lottoValidate.validateWonLotto(wonLottoLastWeek)

    val lottoJudge = LottoJudge()
    val determinedLottoTicket = lottoJudge.determineLottoWinnings(lottoTickets, wonLottoLastWeek.map { it.toInt() })

    val resultView = ResultView()
    resultView.printPurchaseAmount(lottoPurchaseAmount)
    resultView.printPurchaseLottoTickets(lottoTickets)
    resultView.printWinningStatistics(determinedLottoTicket, money)
}
