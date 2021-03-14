package lotto.model

import lotto.model.number.CandidateNumbers
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class CandidateNumbersTest {
    @ParameterizedTest
    @MethodSource("numbersProvider")
    fun `로또 티켓은 6개의 로또 숫자로 이루어져 있다`(numbers: List<Int>) {
        assertThrows<IllegalArgumentException> {
            CandidateNumbers(numbers)
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
