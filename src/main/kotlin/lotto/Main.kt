package lotto

import lotto.ui.Lotto
import lotto.ui.ResultView

fun main() {
    val resultView = ResultView()
    Lotto(resultView).play()
}
