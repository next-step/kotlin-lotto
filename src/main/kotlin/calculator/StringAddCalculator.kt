package calculator

import calculator.NumberExtractor.extract
import calculator.vo.PositiveNum

object StringAddCalculator {
    private const val RETURN_VALUE = 0

    fun add(text: String?): PositiveNum {
        if (text.isNullOrEmpty()) {
            return PositiveNum(RETURN_VALUE)
        }

        val tokens = extract(text)
        return tokens.sum()
    }
}
