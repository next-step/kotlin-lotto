package stringAdditionCalculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SeparatorParserTest {

    @Test
    fun `커스텀 구분자를 입력 받을 경우, 커스텀 구분자를 인식할 수 있다`() {
        val separatorParser: SeparatorParser = SeparatorParser()

        val result: List<String> = separatorParser.extractCustomSeparatorList("//b\\n1b2b3b4b5")

        assertThat(result).containsExactly("b")
    }

    @Test
    fun `,로 구분된 커스텀 구분자를 받을 경우, 모든 커스텀 구분자를 인식할 수 있다`() {
        val separatorParser: SeparatorParser = SeparatorParser()

        val result: List<String> = separatorParser.extractCustomSeparatorList("//b,c\\n1b2c3b4c5")

        assertThat(result).containsExactly("b", "c")
    }

    @Test
    fun `커스텀 구분자가 없을 경우, Default SeparatorList를 반환한다`() {
        val separatorParser: SeparatorParser = SeparatorParser()

        val result: List<String> = separatorParser.extractCustomSeparatorList("1,2,3,4,5")

        assertThat(result).isEqualTo(SeparatorParser.DEFAULT_SEPARATOR_LIST)
    }
}
