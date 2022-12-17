package lotto.domain.model

import lotto.Tokenizer
import lotto.domain.LottoNumberValidator

class WinningNumbers(winningNumberText: String, val bonusNumber: LottoNumber) : Lotto(makeLottoNumbers(winningNumberText)) {

    companion object {

        fun makeLottoNumbers(winningNumberText: String): List<LottoNumber> {
            check(LottoNumberValidator.validate(winningNumberText))
            return Tokenizer.tokenize(winningNumberText).map { LottoNumber(it.toInt()) }
        }
    }
}
