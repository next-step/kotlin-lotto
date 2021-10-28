package lotto.model

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoNumbersTest {

    @DisplayName("로또 번호의 숫자가 0 보다 작거나 45보다 크다면 RuntimeException 예외가 발생해야 한다.")
    @ParameterizedTest
    @ValueSource(
        strings = [
            "-1, 2, 3, 4, 5, 6",
            "1, 2, 3, 4, 5, 50"
        ]
    )
    fun lottoRange(input: String) {
        assertThrows<RuntimeException> {
            createLottoNumbers(input)
        }
    }

    @DisplayName("로또 번호가 중복되면 RuntimeException 예외가 발생해야 한다.")
    @ParameterizedTest
    @ValueSource(
        strings = [
            "1, 2, 3, 4, 5, 5",
            "1, 1, 2, 3, 4, 5"
        ]
    )
    fun lottoDuplicate(input: String) {
        assertThrows<RuntimeException> {
            createLottoNumbers(input)
        }
    }

    private fun createLottoNumbers(input: String): LottoNumbers {
        val numbers = input.split(",").map { it.trim().toInt() }
        return LottoNumbers(
            num1 = numbers[0],
            num2 = numbers[1],
            num3 = numbers[2],
            num4 = numbers[3],
            num5 = numbers[4],
            num6 = numbers[5],
        )
    }
}
