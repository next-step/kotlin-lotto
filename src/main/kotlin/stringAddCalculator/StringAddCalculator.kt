package stringAddCalculator

import java.lang.RuntimeException

class StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrBlank()) {
            return 0
        }
        val tokens = Tokenizer.tokenize(text)
        if (!Tokenizer.validatePositive(tokens)) {
            throw RuntimeException("음수는 입력할 수 없습니다.")
        }
        return additionCalculator.add(tokens)
    }

    companion object {
        @JvmField
        val additionCalculator = AdditionCalculator()
    }
}