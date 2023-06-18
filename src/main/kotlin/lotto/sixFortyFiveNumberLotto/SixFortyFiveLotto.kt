package lotto.sixFortyFiveNumberLotto

import lotto.Lotto
import lotto.view.output.OutputView

class SixFortyFiveLotto(val numbers: SixFortyFiveLottoNumber) :
    Lotto<SixFortyFiveLottoWinningNumber, SixFortyFiveLottoWinningResult> {

    override fun renderLotto(outputView: OutputView) {
        outputView.renderMessage()
    }

    override fun checkWinning(winningValue: SixFortyFiveLottoWinningNumber): SixFortyFiveLottoWinningResult {
        return SixFortyFiveLottoWinningResult.of(numbers, winningValue)
    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}
