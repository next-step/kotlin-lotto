package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoNumbersTest {

    @DisplayName("로또 번호가 중복되면 RuntimeException 예외가 발생해야 한다.")
    @Test
    fun lottoDuplicate() {
        assertThrows<RuntimeException> {
            LottoNumbers.manual(1, 2, 3, 4, 5, 5)
        }
    }

    @DisplayName("로또 번호는 다른 로또 번호와 순서와 상관 없이 일치한 개수를 반환한다.")
    @Test
    fun lottoSameCount() {
        val numbers1 = LottoNumbers.manual(1, 2, 3, 4, 5, 6)
        val numbers2 = LottoNumbers.manual(6, 5, 4, 3, 2, 1)

        val expected = 6
        val actual = numbers1.match(numbers2)
        assertThat(actual).isEqualTo(expected)
    }
}
