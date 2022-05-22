package lotto

import lotto.agency.LottoJudge
import lotto.seller.LottoSeller
import lotto.utils.TextConverter
import lotto.validation.LottoValidate
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val textConverter = TextConverter()
    val inputView = InputView()
    val textMoney = inputView.enterMoney()

    val lottoValidate = LottoValidate()
    lottoValidate.validatePurchase(textMoney)

    val money = textConverter.toNumeric(textMoney)
    val lottoSeller = LottoSeller()
    val lottoPurchaseAmount = lottoSeller.calculateLottoPurchaseAmount(money)
    val lottoTickets = lottoSeller.sell(lottoPurchaseAmount)

    val textWonLotto = inputView.enterWonLotto()
    lottoValidate.validateWonLotto(textWonLotto)
    val wonLotto = textConverter.toNumerics(textWonLotto)

    val lottoJudge = LottoJudge()
    val determinedLottoTicket = lottoJudge.determineLottoWinnings(lottoTickets, wonLotto)

    val resultView = ResultView()
    resultView.printPurchaseAmount(lottoPurchaseAmount)
    resultView.printPurchaseLottoTickets(lottoTickets)
    resultView.printWinningStatistics(determinedLottoTicket, money)
}
