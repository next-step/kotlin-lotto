package lotto

import lotto.view.output.OutputView

class SixFortyFiveLotto(val numbers: SixFortyFiveLottoNumber) : Lotto<SixFortyFiveLottoNumber, Int> {

    override fun renderLotto(outputView: OutputView) {
        outputView.renderMessage()
    }

    override fun checkWinning(winningValue: SixFortyFiveLottoNumber): Int {
        return numbers.value.count { winningValue.value.contains(it) }
    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}
