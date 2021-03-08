package adder.model

import org.assertj.core.api.Assertions.assertThat
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
}
