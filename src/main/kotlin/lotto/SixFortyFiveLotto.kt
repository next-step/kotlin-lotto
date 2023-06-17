package lotto

import lotto.view.output.OutputView

class SixFortyFiveLotto(val numbers: SixFortyFiveLottoNumber) : Lotto<List<Int>, Int> {

    override fun renderLotto(outputView: OutputView) {
        outputView.renderMessage()
    }

    override fun checkWinning(winningValue: List<Int>): Int {
        return numbers.value.count { winningValue.contains(it) }
    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}
