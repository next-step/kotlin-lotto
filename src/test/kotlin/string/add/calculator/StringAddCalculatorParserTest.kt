package string.add.calculator

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class StringAddCalculatorParserTest {
    private lateinit var parser: StringAddCalculatorParser

    @BeforeEach
    fun setUp() {
        parser = StringAddCalculatorParser()
    }

    @Test
    fun `주어진 텍스트에서 숫자 문자열을 분리할 수 있다`() {
        val text = "1,2,3"
        Assertions.assertThat(parser.parseText(text)).isEqualTo(listOf("1","2","3"))
    }

    @Test
    fun `주어진 텍스트에서 커스텀 구분자로 숫자 문자열을 분리할 수 있다`() {
        val text = "//;\n1;2;3"
        Assertions.assertThat(parser.parseText(text)).isEqualTo(listOf("1","2","3"))
    }
}
