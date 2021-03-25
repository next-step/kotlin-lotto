package lotto.model

import lotto.model.number.LottoNumbers
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class LottoNumbersTest {
    @ParameterizedTest
    @MethodSource("numbersProvider")
    fun `로또 티켓은 6개의 로또 숫자로 이루어져 있다`(numbers: List<Int>) {
        assertThrows<IllegalArgumentException> {
            LottoNumbers(numbers)
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
