package lotto.domain.model

import lotto.Tokenizer
import lotto.domain.LottoNumberValidator

class WinningNumbers(numbers: List<LottoNumber>) : Lotto(numbers) {

    companion object {

        fun makeWinningNumbers(winningNumberText: String): WinningNumbers {
            check(LottoNumberValidator.validate(winningNumberText))
            val numbers: List<LottoNumber> = Tokenizer.tokenize(winningNumberText)
                .map {
                    LottoNumber(it.toInt())
                }
            return WinningNumbers(numbers)
        }
    }
}
