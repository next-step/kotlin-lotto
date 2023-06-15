package lotto

import lotto.view.output.OutputView

class SixFortyFiveLotto(val numbers: List<Int>) : Lotto<List<Int>, Int> {

    override fun renderLotto(outputView: OutputView) {
        outputView.renderMessage()
    }

    override fun checkWinning(winningValue: List<Int>): Int {
        return numbers.count { winningValue.contains(it) }
    }
}
