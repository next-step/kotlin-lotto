package stringcalculator.view

import stringcalculator.domain.StringTokenizer
import stringcalculator.domain.Tokens

object InputView {
    fun input(): Tokens {
        return StringTokenizer.tokenize(readLine() ?: throw IllegalArgumentException(""))
    }
}
