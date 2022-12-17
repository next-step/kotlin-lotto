package lotto.domain.model

import lotto.Tokenizer
import lotto.domain.LottoNumberValidator

class WinningNumbers(winningNumberText: String) {

    val numbers: List<LottoNumber> = initList(winningNumberText)

    private fun initList(winningNumberText: String): List<LottoNumber> {
        check(LottoNumberValidator.validate(winningNumberText)) { "유효하지 않은 당첨 번호 입니다" }
        return Tokenizer.tokenize(winningNumberText).map { LottoNumber(it.toInt()) }
    }
}
