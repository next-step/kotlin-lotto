package lotto.domain.model

import lotto.Tokenizer

class WinningNumbers(winningNumberText: String) {

    val numbers: List<LottoNumber> = initList(winningNumberText)

    private fun initList(winningNumberText: String): List<LottoNumber> {
        return Tokenizer.tokenize(winningNumberText).map { LottoNumber(it.toInt()) }
    }
}
