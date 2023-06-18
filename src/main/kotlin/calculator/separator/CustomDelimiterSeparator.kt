package calculator.separator

import calculator.vo.Delimiter

interface CustomDelimiterSeparator {
    fun separateFrom(target: String): Pair<Delimiter?, String>
}
