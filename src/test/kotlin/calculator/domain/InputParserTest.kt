package calculator.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

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
}
