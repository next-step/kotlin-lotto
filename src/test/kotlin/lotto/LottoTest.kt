package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTest {

    @Test
    fun `로또번호 6개로 로또를 생성할 수 있다`() {
        val lottoNumbers = (1..6).map { LottoNumber(it) }
        val result = Lotto(lottoNumbers)
        assertThat(result).isNotNull
    }
}
