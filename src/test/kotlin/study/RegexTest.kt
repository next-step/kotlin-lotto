package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RegexTest {
    @Test
    fun `regex matches test`() {
        val regex = """.*ab.b""".toRegex()

        assertThat(regex.matches("asdabbb")).isEqualTo(true)
        assertThat(regex.matches("abbb")).isEqualTo(true)
        assertThat(regex.matches("123abb")).isEqualTo(false)
        assertThat(regex.matches("ab3bb")).isEqualTo(false)
    }

    @Test
    fun `regex find test`() {
        val regex = """a.c""".toRegex()

        assertThat(regex.find("abc")?.value).isEqualTo("abc")
        assertThat(regex.find("abccccabc")?.value).isEqualTo("abc")
    }

    @Test
    fun `regex groupValues test`() {
        val regex = """ab(.)d(.*)"""
        val strings = regex.toRegex().find("abld123")?.groupValues

        assertThat(strings?.get(0)).isEqualTo("abld123")
        assertThat(strings?.get(1)).isEqualTo("l")
        assertThat(strings?.get(2)).isEqualTo("123")
    }
}
