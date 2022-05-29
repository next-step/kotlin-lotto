package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoTest {
    @Test
    fun `로또는 1~45범위 숫자 중 랜덤한 숫자 6개로 이뤄져야 한다`() {
        val lottoNumbers = Lotto().lottoNumbers
        assertEquals(6, lottoNumbers.size)
        lottoNumbers.map { lottoNumber ->
            Assertions.assertThat(lottoNumber).isBetween(1, 45)
        }
    }
}
