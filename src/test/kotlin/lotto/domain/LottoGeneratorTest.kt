package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoGeneratorTest {
    @Test
    fun `로또 번호는 6개의 숫자로 이루어져 있다`() {
        val lotto = LottoGenerator.generateNumbers()
        val lottoNumbers = (1..45).map { LottoNumber.get(it) }.toSet()

        lotto.map {
            assertThat(lottoNumbers.contains(it)).isTrue()
        }

        assertThat(lotto.size).isEqualTo(6)
    }
}
