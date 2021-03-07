package stringaddcalculator.util

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.DisplayName

internal class ExpressionParserTest {

    @Test
    @DisplayName("입력에 커스텀 구분자가 있으면 그 그분자로 입력을 분리한다")
    fun parseCustomInput() {
        val parseInput = ExpressionParser().parse("//;\n1;2;3")
        assertThat(parseInput).containsSequence("1", "2", "3")
    }

    @Test
    @DisplayName("입력에 커스텀 구분자가 없으면 기본 구분자로 입력을 분리한다")
    internal fun parseDefaultInput() {
        val parseInput = ExpressionParser().parse("1:2,3")
        assertThat(parseInput).containsSequence("1", "2", "3")
    }
}
