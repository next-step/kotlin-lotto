package text

import org.junit.jupiter.api.Assertions.assertEquals
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
        assertEquals("1,2,3,4,6", matchResult.groups[3]!!.value)

        val (_, delimiter, exp) = matchResult.destructured
        assertTrue(delimiter.isEmpty())
        assertEquals("1,2,3,4,6", exp)
    }

    @Test
    internal fun customDelimiterPatternTest() {
        assertTrue(PATTERN.matches("//;\n1;12;3"))
        assertTrue(PATTERN.matches("//+\n1+32"))
        assertTrue(PATTERN.matches("//-\n100-2-14-5"))
        assertTrue(PATTERN.matches("1,2,3,4"))
        assertTrue(PATTERN.matches("1:2:3"))

        val matchResult = requireNotNull(PATTERN.matchEntire("//-\n100-2-14-5"))

        assertEquals("-", matchResult.groups[2]!!.value)
        assertEquals("100-2-14-5", matchResult.groups[3]!!.value)

        val (_, delimiter, exp) = matchResult.destructured
        assertEquals("-", delimiter)
        assertEquals("100-2-14-5", exp)
    }

    companion object {
        val PATTERN = Regex("""^(//(.)\n)?((\d+(\2|[,:])?)+)$""")
    }
}
