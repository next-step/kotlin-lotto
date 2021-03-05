package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StringTest {

    @Test
    fun test() {
        assertThat("1,2".contains(",")).isTrue()
        assertThat("1,2".replace(",".toRegex(), "")).isEqualTo("12")
        assertThat("1:2".replace(":".toRegex(), "")).isEqualTo("12")
        assertThat("1,2:".replace("[,]|[:]".toRegex(), "")).isEqualTo("12")
        val input = "//;\n1//^\n2;3"
        val customDelimiters = Regex("//(.)\n").findAll(input)
            .map {
                it.let {
                    it.groupValues[1]
                }
            }.toList()
        assertThat(customDelimiters).containsAll(listOf(";", "^"))
    }
}
