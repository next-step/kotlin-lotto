package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoNumberTest {

    @Test
    fun `로또 번호는 1-45사이의 숫자다`() {
        val lottoNumber: LottoNumber = LottoNumber.get(1)
        assertThat(lottoNumber).isInstanceOf(LottoNumber::class.java)
    }
}
