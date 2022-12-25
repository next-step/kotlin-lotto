package lotto.domain.model

import lotto.Tokenizer
import lotto.domain.LottoNumberValidator

class Winning(val winningNumbers: List<LottoNumber>, val bonusNumber: LottoNumber) : Lotto(winningNumbers) {

    companion object {

        fun makeLottoNumbers(winningNumberText: String): List<LottoNumber> {
            check(LottoNumberValidator.validate(winningNumberText))
            return Tokenizer.tokenize(winningNumberText).map { LottoNumber(it.toInt()) }
        }
    }
}
