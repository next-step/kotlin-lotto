package lotto

import lotto.ui.InputParser
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource

class InputParserTest {
    @ParameterizedTest
    @ValueSource(strings = ["1, 2, 3# 4, 5, 6", "1; 2, 3, 4, 5, 6"])
    fun `당첨 번호 입력할 때 구분자로 콤마(,)를 사용하지 않으면 RunTimeException 발생`(numbers: String) {
        assertThatIllegalArgumentException().isThrownBy {
            InputParser.parse(numbers)
        }
    }

    @ParameterizedTest
    @MethodSource("winningNumberTest")
    fun `당첨 번호 입력하면 Lotto class로 반환`(numbers: String, lottoNumbers: Set<Int>) {
        assertThat(InputParser.parse(numbers)).isEqualTo(Lotto(lottoNumbers))
    }

    companion object {
        @JvmStatic
        private fun winningNumberTest(): List<Arguments> {
            return listOf(
                Arguments.of("1, 2, 3, 4, 5, 6", setOf(1, 2, 3, 4, 5, 6)),
                Arguments.of("10, 20, 30, 40, 41, 42", setOf(10, 20, 30, 40, 41, 42))
            )
        }
    }
}
