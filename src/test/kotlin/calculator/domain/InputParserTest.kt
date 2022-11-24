package calculator.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class InputParserTest {
    private lateinit var inputParser: InputParser
    private val expected = arrayOf(1, 2, 3)

    @BeforeEach
    fun setUp() {
        // given
        inputParser = InputParser
    }

    @DisplayName("기본 구분자 및 커스텀 구분자 테스트")
    @ParameterizedTest
    @ValueSource(strings = ["1,2,3", "1,2:3", "//;\n1;2;3"])
    fun `쉼표 구분자 테스트`(given: String) {
        // when
        val actualResult = inputParser.parseWithDelimiter(given)

        // then
        assertThat(actualResult).isEqualTo(expected)
    }

    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0 반환 테스트")
    @ParameterizedTest
    @NullAndEmptySource
    fun `빈 문자열 또는 null 값을 입력할 경우 0 반환 테스트`(given: String?) {
        // when
        val actualResult = inputParser.parseWithDelimiter(given)

        // then
        assertThat(actualResult).isEqualTo(arrayOf(0))
    }

    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자 반환 테스트")
    @Test
    fun `숫자 하나를 문자열로 입력할 경우 해당 숫자 반환 테스트`() {
        // when
        val actualResult = inputParser.parseWithDelimiter("1")

        // then
        assertThat(actualResult).isEqualTo(arrayOf(1))
    }

    @DisplayName("입력된 값이 숫자인지 확인하는 테스트")
    @ParameterizedTest
    @ValueSource(strings = [" ", "a", "1a", "a1", "1 1", " 1", "1 "])
    fun `입력된 값이 숫자인지 확인하는 테스트`(input: String) {
        assertThatThrownBy { inputParser.parseWithDelimiter(input) }
            .isInstanceOf(RuntimeException::class.java)
            .hasMessageContaining("숫자 이외의 값은 입력할 수 없습니다.")
    }
}
