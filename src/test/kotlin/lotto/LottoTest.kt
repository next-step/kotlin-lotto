package lotto

import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class LottoTest {
    @ParameterizedTest
    @MethodSource("lottoCountTest")
    fun `로또에 6개 숫자를 전달하지 않으면 RuntimeException 발생`(numbers: Set<Int>) {
        assertThatIllegalArgumentException().isThrownBy {
            Lotto(numbers)
        }
    }

    @ParameterizedTest
    @MethodSource("lottoNumberTest")
    fun `로또 번호에 1~45숫자 이외의 값을 전달하면 RuntimeException 발생`(numbers: Set<Int>) {
        assertThatIllegalArgumentException().isThrownBy {
            Lotto(numbers)
        }
    }

    companion object {
        @JvmStatic
        private fun lottoCountTest(): List<Arguments> {
            return listOf(
                Arguments.of(setOf(1, 2, 3)),
                Arguments.of(setOf(1, 2, 3, 4, 5)),
                Arguments.of(setOf(1, 2, 3, 4, 5, 6, 7))
            )
        }

        @JvmStatic
        private fun lottoNumberTest(): List<Arguments> {
            return listOf(
                Arguments.of(setOf(0, 1, 2, 3, 4, 5)),
                Arguments.of(setOf(46, 1, 2, 3, 4, 5)),
            )
        }
    }
}
