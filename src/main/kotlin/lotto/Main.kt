package lotto

import lotto.domain.Lotto
import lotto.ui.InputView
import lotto.ui.ResultView

fun main() {
    val inputView = InputView()
    // 구입 금액 입력
    val (amount: Int, lottoList: List<Lotto>) = inputView.input()
    // 구매 결과 출력
    inputView.showLottoList(lottoList)

    val resultView = ResultView()
    // 지난 주 당첨 번호 입력
    val winningNumbers = resultView.inputWinningNumbers()
    val rewards = resultView.checkWinningLottoList(winningNumbers, lottoList)
    // 당첨 통계 출력
    resultView.showResult(amount, rewards)
}
