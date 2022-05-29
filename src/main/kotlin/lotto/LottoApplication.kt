package lotto

import lotto.domain.LottoPrice
import lotto.domain.LottoPurchase
import lotto.domain.LottoScore
import lotto.domain.WinningNumber
import lotto.view.InputView
import lotto.view.OutputView
import java.lang.IllegalArgumentException

fun main() {
    val inputView = InputView()
    val outputView = OutputView()

    // 구입금액 입력받기
    val price = inputView.getPrice()

    // 구입금액 validation
    val lottoPurchase = LottoPurchase()
    val lottoPrice = LottoPrice(price)

    // 구입금액에 따른 로또 개수 반환
    val lottoCount = lottoPurchase.getLottoCount(lottoPrice)
    outputView.resultPurchaseLotto(lottoCount)

    // 로또 개수에 맞추어 로또 번호 반환
    val lottoTickets = lottoPurchase.getLottoTickets(lottoCount)
    outputView.resultLottoTickets(lottoTickets)

    // 지난주 로또 당첨번호 받기
    val winningNumber = WinningNumber()
    val lastWinningNumbers = inputView.getLastWinningNumbers()
    val lastWinningTicket = try {
        winningNumber.winningNumberToLottoTicket(lastWinningNumbers)
    } catch (e: IllegalArgumentException) {
        print(Const.ErrorMsg.INPUT_VALUE_CANNOT_CONVERSE_LOTTO_WINNING_NUMBER_ERROR_MSG)
        return
    }

    val bonusNumber = inputView.getBonusNumber()
    winningNumber.validBonusNumber(bonusNumber, lastWinningTicket)

    // 당첨통계
    val lottoScore = LottoScore()
    val lottoResults = lottoScore.compareNumber(lastWinningTicket, lottoTickets)
    // 수익률
    val rateResult = lottoScore.rateOfResult(lottoPrice, lottoResults)

    outputView.winningResult(lottoResults, rateResult)
}
