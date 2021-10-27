package study

import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class RegexTest {

    @Test
    fun customDelimiter() {
        val result = Regex("//(.)\n(.*)").find("//;\n1;2;3")

        result?.let {
            val customDelimiter = it.groupValues[1]
            val tokens = it.groupValues[2].split(customDelimiter)
            println(customDelimiter)
            println(tokens)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1|2:3"])
    fun test(text: String) {
        val split = text.split(*listOf("|", ":").toTypedArray())
        println(split)
    }
}
