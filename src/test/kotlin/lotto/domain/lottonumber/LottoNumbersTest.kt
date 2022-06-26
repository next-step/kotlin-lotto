package lotto.domain.lottonumber

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class LottoNumbersTest {
    @Test
    fun `LottoNumbers 생성자 테스트`() {
        // given
        val numbers = listOf(1, 2, 3, 4, 5, 6)

        // when
        val lottoNumbers = LottoNumbers(numbers)

        // then
        assertThat(lottoNumbers.lottoNumbers.size).isEqualTo(6)
        assertThat(lottoNumbers.toInts()).containsExactlyElementsOf(numbers)
    }

    @Test
    fun `LottoNumbers 중복 숫자 Exception 발생`() {
        assertThrows<IllegalArgumentException> {
            LottoNumbers(listOf(1, 1, 1, 1, 1, 1))
        }
    }
}
