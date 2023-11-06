package stringAddCalculator

import java.lang.RuntimeException

object Tokenizer {
    fun tokenize(text: String): List<String> {
        return Separator.separateByCustomDelimiter(text) ?: Separator.separate(text)
    }

    fun validatePositive(tokens: List<String>): Boolean {
        return tokens.all {
            (it.trim().toIntOrNull()?.let { num -> num >= 0 } ?: throw RuntimeException("구분자를 제외한 입력값은 숫자여야 합니다."))
        }
    }
}