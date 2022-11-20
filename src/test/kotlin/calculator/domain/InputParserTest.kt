package calculator.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource

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

    @DisplayName("//와 \\n 문자 사이에 커스텀 구분자 지정 테스트")
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
}
