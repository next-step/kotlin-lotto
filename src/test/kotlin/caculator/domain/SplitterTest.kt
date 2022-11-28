package caculator.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class SplitterTest {
    @DisplayName(value = "구분자를 쉼표(,) 이외에 콜론(:)을 사용할 수 있다.")
    @ParameterizedTest
    @MethodSource("provideColons")
    fun colons(text: String, result: List<String>) {
        val splitter = Splitter(text)
        Assertions.assertThat(splitter.split()).isEqualTo(result)
    }

    @DisplayName(value = "//와 \\n 문자 사이에 커스텀 구분자를 지정할 수 있다.")
    @ParameterizedTest
    @MethodSource("provideCustomDelimiter")
    fun customDelimiter(text: String, result: List<String>) {
        val splitter = Splitter(text)
        Assertions.assertThat(splitter.split()).isEqualTo(result)
    }

    companion object {
        @JvmStatic
        fun provideColons(): Stream<Arguments> {
            return Stream.of(Arguments.of("1,2:3", listOf("1", "2", "3")))
        }

        @JvmStatic
        fun provideCustomDelimiter(): Stream<Arguments> {
            return Stream.of(Arguments.of("//;\n1;2;3", listOf("1", "2", "3")))
        }
    }
}
