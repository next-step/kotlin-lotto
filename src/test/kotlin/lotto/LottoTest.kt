package lotto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
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

    @ParameterizedTest
    @CsvSource(value = ["1, true", "2, true", "10, false", "20, false"])
    fun `로또 번호를 갖고있는지 확인`(number: Int, expect: Boolean) {
        val lotto = Lotto(setOf(1, 2, 3, 4, 5, 6))
        assertThat(lotto.contains(number)).isEqualTo(expect)
    }

    @ParameterizedTest
    @MethodSource("lottoMatchCountTest")
    fun `일치하는 로또 번호가 몇 개 있는지 테스트`(numbers: Set<Int>, expect: Int) {
        val winningLotto = Lotto(setOf(1, 2, 3, 4, 5, 6))
        assertThat(winningLotto.countMatchedNumber(Lotto(numbers))).isEqualTo(expect)
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

        @JvmStatic
        private fun lottoMatchCountTest(): List<Arguments> {
            return listOf(
                Arguments.of(setOf(1, 2, 3, 4, 5, 6), 6),
                Arguments.of(setOf(1, 2, 3, 10, 20, 30), 3),
                Arguments.of(setOf(10, 20, 30, 11, 12, 13), 0),
            )
        }
    }
}
