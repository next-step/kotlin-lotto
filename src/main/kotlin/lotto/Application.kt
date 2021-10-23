package lotto

import lotto.view.input.ConsoleInputView
import lotto.view.result.ConsoleResultView

fun main() {
    LottoGameLauncher(ConsoleInputView(), ConsoleResultView()).launch()
}
