package adder.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DelimiterTest {
    @Test
    fun hasCustom() {
        // given
        val input: String = "//-\\n1-2-3-45-6"

        // when
        val hasCustomDelimiter = Delimiter(input).hasCustom()

        // then
        assertThat(hasCustomDelimiter).isTrue()
    }
}
