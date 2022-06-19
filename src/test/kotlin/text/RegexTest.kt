package text

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class RegexTest {

    @Test
    internal fun defaultDelimiterPatternTest() {
        assertTrue(PATTERN.matches("1,2,3,4"))
        assertTrue(PATTERN.matches("10:400:3"))

        val matchResult = requireNotNull(PATTERN.matchEntire("1,2,3,4,6"))

        assertNull(matchResult.groups[2])
        assertThat(matchResult.groups[3]!!.value).isEqualTo("1,2,3,4,6")

        val (_, delimiter, exp) = matchResult.destructured
        assertTrue(delimiter.isEmpty())
        assertThat(exp).isEqualTo("1,2,3,4,6")
    }

    @Test
    internal fun customDelimiterPatternTest() {
        assertTrue(PATTERN.matches("//;\n1;12;3"))
        assertTrue(PATTERN.matches("//+\n1+32"))
        assertTrue(PATTERN.matches("//-\n100-2-14-5"))
        assertTrue(PATTERN.matches("1,2,3,4"))
        assertTrue(PATTERN.matches("1:2:3"))

        val matchResult = requireNotNull(PATTERN.matchEntire("//-\n100-2-14-5"))

        assertThat(matchResult.groups[2]!!.value).isEqualTo("-")
        assertThat(matchResult.groups[3]!!.value).isEqualTo("100-2-14-5")

        val (_, delimiter, exp) = matchResult.destructured
        assertThat(delimiter).isEqualTo("-")
        assertThat(exp).isEqualTo("100-2-14-5")
    }

    companion object {
        val PATTERN = Regex("""^(//(.)\n)?((\d+(\2|[,:])?)+)$""")
    }
}
