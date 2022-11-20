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
        inputParser = InputParser()
    }

    @DisplayName("쉼표(,) 구분자 테스트")
    @Test
    fun `쉼표 구분자 테스트`() {
        assertThat(inputParser.parseWithDelimiter("1,2,3")).isEqualTo(expected)
    }

    @DisplayName("쉼표(,) 콜론(:) 구분자 테스트")
    @Test
    fun `쉼표,콜론 구분자 테스트`() {
        assertThat(inputParser.parseWithDelimiter("1,2:3")).isEqualTo(expected)
    }

    @DisplayName("//와 \n 문자 사이에 커스텀 구분자 지정 테스트")
    @Test
    fun `커스텀 구분자 테스트`() {
        assertThat(inputParser.parseWithDelimiter("//;\n1;2;3")).isEqualTo(expected)
    }

    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0 반환 테스트")
    @ParameterizedTest
    @NullAndEmptySource
    fun `빈 문자열 또는 null 값을 입력할 경우 0 반환 테스트`(text: String?) {
        assertThat(inputParser.parseWithDelimiter(text)).isEqualTo(arrayOf(0))
    }

    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자 반환 테스트")
    @Test
    fun `숫자 하나를 문자열로 입력할 경우 해당 숫자 반환 테스트`() {
        assertThat(inputParser.parseWithDelimiter("1")).isEqualTo(arrayOf(1))
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
