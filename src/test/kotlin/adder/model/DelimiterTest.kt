package adder.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class DelimiterTest {
    @ParameterizedTest
    @CsvSource(value = ["//-\\n1-2-3-45-6:true", "1,2,3,45,6:false"], delimiter = ':')
    fun hasCustom(input: String, hasCustom: Boolean) {
        // when
        val hasCustomDelimiter = Delimiter(input).hasCustom()

        // then
        assertThat(hasCustomDelimiter).isEqualTo(hasCustom)
    }

    @Test
    fun splitByCustomDelimiter() {
        // given
        val input = "//-\\n1-2-3-45-6"

        // when
        val dividedInput: List<String> = Delimiter(input).split()

        // then
        assertThat(dividedInput).isEqualTo(listOf("1", "2", "3", "45", "6"))
    }

    @Test
    fun splitByDefaultDelimiter() {
        // given
        val input = "1,2,3,45,6"

        // when
        val dividedInput: List<String> = Delimiter(input).split()

        // then
        assertThat(dividedInput).isEqualTo(listOf("1", "2", "3", "45", "6"))
    }
}
