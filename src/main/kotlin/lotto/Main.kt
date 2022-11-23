package lotto

import lotto.domain.LottoDispenser
import lotto.ui.InputView
import lotto.ui.ResultView

fun main() {
    val inputView = InputView()

    // 구입 금액 입력 후 구매 결과 출력
    val amount = inputView.inputAmount()
    val lottoList = LottoDispenser(amount).list
    inputView.showPurchaseResult(lottoList)

    // 지난 주 당첨 번호 입력 후 당첨 통계 출력
    val resultView = ResultView()
    val winningNumbers = resultView.inputWinningNumber()
    lottoList.forEach { it.win(winningNumbers) }
    resultView.showResult(amount, lottoList)
}
