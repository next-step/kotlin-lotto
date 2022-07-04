package lotto

import lotto.entity.Lotto
import lotto.ui.ResultView

fun main() {
    val resultView = ResultView()
    Lotto(resultView).play()
}
