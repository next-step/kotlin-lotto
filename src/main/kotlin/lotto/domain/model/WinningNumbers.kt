package lotto.domain.model

import lotto.Tokenizer

class WinningNumbers(winningNumberText: String) : Lotto(makeLottoNumbers(winningNumberText)) {

    companion object {

        fun makeLottoNumbers(winningNumberText: String): List<LottoNumber> {
            return Tokenizer.tokenize(winningNumberText).map { LottoNumber(it.toInt()) }
        }
    }
}
