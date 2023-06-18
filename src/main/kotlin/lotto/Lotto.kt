package lotto

import lotto.view.output.OutputView

interface Lotto<T, V> {
    fun renderLotto(outputView: OutputView)
    fun checkWinning(winningValue: T): V
}
