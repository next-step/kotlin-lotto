package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoNumbersTest {

    @DisplayName("로또 번호의 숫자가 1 보다 작거나 45보다 크다면 RuntimeException 예외가 발생해야 한다.")
    @Test
    fun lottoRange(input: String) {
        assertThrows<RuntimeException> {
            LottoNumbers(-1, 2, 3, 4, 5, 6)
        }
    }

    @DisplayName("로또 번호가 중복되면 RuntimeException 예외가 발생해야 한다.")
    @Test
    fun lottoDuplicate(input: String) {
        assertThrows<RuntimeException> {
            LottoNumbers(1, 2, 3, 4, 5, 5)
        }
    }

    @ParameterizedTest(name = "로또 번호는 다른 로또 번호와 순서와 상관 없이 일치한 개수를 반환한다.")
    @CsvSource(
        value = [
            "1, 2, 3, 4, 5, 6|6, 5, 4, 3, 2, 1|6",
            "10, 20, 30, 40, 41, 45|10, 30, 20, 5, 6, 7|3"
        ],
        delimiter = '|'
    )
    fun lottoSameCount(numbers1String: String, numbers2String: String, sameCount: String) {
        val numbers1 = LottoNumbers(1, 2, 3, 4, 5, 6)
        val numbers2 = LottoNumbers(6, 5, 4, 3, 2, 1)

        val expected = sameCount.toInt()
        val actual = numbers1.match(numbers2)
        assertThat(actual).isEqualTo(expected)
    }
}
