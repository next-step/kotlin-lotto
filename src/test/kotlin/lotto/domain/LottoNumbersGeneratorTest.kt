package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoNumbersGeneratorTest {
    @Test
    fun `로또 번호 생성`() {
        val lottoNumbers = LottoNumberGenerator.generate()
        assertThat(lottoNumbers.numbers.size == 6)
        lottoNumbers.numbers.forEach {
            assertThat(it.number).isBetween(1, 45)
        }
    }
}
