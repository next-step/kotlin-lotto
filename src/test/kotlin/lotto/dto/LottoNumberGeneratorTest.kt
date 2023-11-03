package lotto.dto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoNumberGeneratorTest {
    @Test
    fun `로또 번호 생성`() {
        val lottoNumber = LottoNumberGenerator.generate()
        assertThat(lottoNumber.numbers.size == 6)
        lottoNumber.numbers.forEach {
            assertThat(it).isBetween(1, 45)
        }
    }
}
