package lotto

import lotto.process.LottoPurchase
import lotto.process.LottoPurchase.Companion.LOTTO_PRICE
import lotto.process.LottoScore
import lotto.process.WinningNumber
import lotto.view.InputView
import lotto.view.OutputView
import java.lang.IllegalArgumentException

fun main() {
    val inputView = InputView()
    val outputView = OutputView()

    // 구입금액 입력받기
    val price = inputView.readPrice()

    // 구입금액 validation
    val lottoPurchase = LottoPurchase()
    val lottoPrice = lottoPurchase.getMoney(price)

    if (lottoPrice.get() < LOTTO_PRICE) {
        outputView.cannotPurchaseLotto()
        return
    }

    // 구입금액에 따른 로또 개수 반환
    val lottoCount = lottoPurchase.getLotto(lottoPrice)
    outputView.resultPurchaseLotto(lottoCount)

    // 로또 개수에 맞추어 로또 번호 반환
    val lottoTickets = lottoPurchase.getLottoTickets(lottoCount)
    outputView.resultLottoTickets(lottoTickets)

    // 지난주 로또 당첨번호 받기
    val lastWinningNumber = inputView.readWinningNum()
    val lastWinningTicket = try {
        WinningNumber().winningNumberToLottoTicket(lastWinningNumber)
    } catch (e: IllegalArgumentException) {
        print(Const.ErrorMsg.INPUT_VALUE_CANNOT_CONVERSE_LOTTO_WINNING_NUMBER_ERROR)
        return
    }

    // 당첨통계
    val lottoScore = LottoScore()
    val lottoResults = lottoScore.compareNumber(lastWinningTicket, lottoTickets)
    outputView.winningResult(lottoResults)

    // 수익률
    val rateResult = lottoScore.rateOfResult(lottoPrice, lottoResults)
    outputView.winningRate(rateResult)
}
