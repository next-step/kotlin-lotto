package study

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class RegexTest {

    @ParameterizedTest
    @ValueSource(strings = ["//;\n1;2;3"])
    fun customDelimiter(text: String) {
        val result = Regex("//(.)\n(.*)").find(text)

        result?.let {
            val customDelimiter = it.groupValues[1]
            val tokens = it.groupValues[2].split(customDelimiter)
            println(customDelimiter)
            println(tokens)
        }
    }
}
