package lotto

import lotto.view.InputView

fun main() {
    val inputView: InputView = InputView()

    val buyingPrice: Int = inputView.readLineNumber("구입금액을 입력해 주세요.")
}
