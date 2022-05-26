package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoGeneratorTest {
    @Test
    fun `로또번호는 1~45 사이 숫자, 6개를 발급한다`() {
        val expectCount = 6
        val lottoNumbers = LottoGenerator().generateNumbers()
        assertThat(lottoNumbers.size).isEqualTo(expectCount)
        val invalidNumber = lottoNumbers.filter { it.number !in 1..45 }
        assertThat(invalidNumber).isEmpty()
    }
}
