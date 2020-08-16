package kotlintest

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class KotlinTest {
    @Test
    fun setTest() {
        val set = setOf(1, 2, 3, 4, 5, 5)
        assertThat(set.size).isEqualTo(5)
    }

    @Test
    fun stringFormatTest() {
        val i = String.format("%d원", 1)
        assertThat(i).isEqualTo("1원")

        val str = String.format("%s" + "def", "abc")
        assertThat(str).isEqualTo("abcdef")

        val FFF = "FFF"
        val strKotlin = String.format("%s$FFF", "abc")
        assertThat(strKotlin).isEqualTo("abcFFF")
    }
}
