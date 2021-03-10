package lotto.model

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class LottoNumbersTest {
    @ParameterizedTest
    @MethodSource("numbersProvider")
    fun `로또 숫자는 6개로 이루어져 있다`(numbers: List<Int>) {
        assertThrows<IllegalArgumentException> {
            LottoNumbers.from(numbers)
        }
    }

    companion object {
        @JvmStatic
        fun numbersProvider(): List<Arguments> {
            return listOf(
                Arguments {
                    arrayOf(listOf(1, 2, 3, 4, 5))
                },
                Arguments {
                    arrayOf(listOf(1, 2, 3, 4, 5, 6, 7))
                }
            )
        }
    }
}
