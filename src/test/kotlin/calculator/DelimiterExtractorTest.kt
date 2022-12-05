package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.ValueSource

internal class DelimiterExtractorTest {

    @EmptySource
    @ParameterizedTest(name = "빈 값이 들어가면 IllegalArgumentException 이 발생한다.")
    internal fun inputEmptyTest(input: String) {
        // given

        // when, then
        assertThatIllegalArgumentException()
            .isThrownBy { DelimiterExtractor.extractNumbers(input) }
    }

    @ValueSource(strings = ["1,2,3", "1,2:3", "1:2:3"])
    @ParameterizedTest(name = "[{arguments}] `,` 또는 `:` 을 구분하여 PositiveNumber 리스트를 반환된다.")
    internal fun inputDelimiterTest(input: String) {
        // given

        // when
        val result = DelimiterExtractor.extractNumbers(input)

        // then
        assertThat(result).containsExactly(PositiveNumber(1), PositiveNumber(2), PositiveNumber(3))
    }

    @ValueSource(strings = ["//;\n1;2;3", "//.\n1.2.3"])
    @ParameterizedTest(name = "[{arguments}]  `\\` 와 `\\n` 사이에 커스텀 구분자로 구분된 PositiveNumber 리스트를 반환한다.")
    internal fun inputCustomDelimiterTest(input: String) {
        // given

        // when
        val result = DelimiterExtractor.extractNumbers(input)

        // then
        assertThat(result).containsExactly(PositiveNumber(1), PositiveNumber(2), PositiveNumber(3))
    }
}
