package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoNumberTest {

    @Test
    fun `로또번호 생성`() {
        val value = 1
        val result = LottoNumber(value)
        assertThat(result).isNotNull
    }
}
