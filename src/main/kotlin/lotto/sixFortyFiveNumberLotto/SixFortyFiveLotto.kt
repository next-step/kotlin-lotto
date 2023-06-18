package lotto.sixFortyFiveNumberLotto

import lotto.Lotto

class SixFortyFiveLotto(val numbers: SixFortyFiveLottoNumber) :
    Lotto<SixFortyFiveLottoWinningNumber, SixFortyFiveLottoWinningResult> {

    override fun checkWinning(winningValue: SixFortyFiveLottoWinningNumber): SixFortyFiveLottoWinningResult {
        return SixFortyFiveLottoWinningResult.of(numbers, winningValue)
    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}
