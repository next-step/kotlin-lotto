package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoNumbersTest {
    @Test
    fun `로또 번호는 중복 없는 6개의 숫자로 만들 수 있다`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)

        val lotto = LottoNumbers.of(numbers)

        assertThat(lotto.numbers).isEqualTo(listOf(1, 2, 3, 4, 5, 6))
    }

    @Test
    fun `로또 번호는 6개가 아니면 안된다`() {
        val numbers = listOf(1)

        assertThrows<IllegalArgumentException> {
            LottoNumbers.of(numbers)
        }
    }

    @Test
    fun `로또 번호는 중복이 있으면 안된다`() {
        val numbers = listOf(1, 1, 1, 1, 1, 1)

        assertThrows<IllegalArgumentException> {
            LottoNumbers.of(numbers)
        }
    }

    @Test
    fun `로또 번호는 정렬되어 있지 않으면 안된다`() {
        val numbers = listOf(6, 5, 4, 3, 2, 1)

        assertThrows<IllegalArgumentException> {
            LottoNumbers.of(numbers)
        }
    }
}
