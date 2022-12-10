package lotto.domain.model

import calculator.Tokenizer
import lotto.domain.LottoNumberValidator

class WinningNumbers(winningNumberText: String) {

    val numbers: List<Int> = initList(winningNumberText)

    private fun initList(numberText: String): List<Int> {
        check(LottoNumberValidator.validate(numberText)) { "유효하지 않은 당첨 번호 입니다" }
        return Tokenizer.tokenize(numberText).map { it.toInt() }
    }
}
