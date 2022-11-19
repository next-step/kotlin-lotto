package calculator

import calculator.util.DelimiterExtractor
import calculator.util.Parser

object Calculator {
    fun calculate(rawString: String?): Int {
        if (rawString.isNullOrBlank()) {
            return 0
        }

        val calculationInfo = DelimiterExtractor.extract(rawString)
        val numbers = Parser.parse(calculationInfo.delimiter, calculationInfo.expression)
        return numbers.sum()
    }
}
