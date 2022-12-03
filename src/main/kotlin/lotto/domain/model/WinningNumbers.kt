package lotto.domain.model

import calculator.Tokenizer
import lotto.domain.LottoNumberValidator

class WinningNumbers(winningNumberString: String) {

    val numbers: List<Int> = initList(winningNumberString)

    private fun initList(input: String): List<Int> {
        check(LottoNumberValidator.validate(input)) { "유효하지 않은 당첨 번호 입니다" }
        return Tokenizer.tokenize(input).map { it.toInt() }
    }
}
