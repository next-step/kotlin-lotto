package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoGeneratorTest {
    @Test
    fun `특정 규칙으로 로또번호를 발행할 수 있다`() {
        val lottoNumbersGenerateStrategy = LottoNumbersGenerateStrategy {
            LottoNumbers.of(listOf(1, 2, 3, 4, 5, 6))
        }

        val generator = LottoGenerator()
        val lotto = generator.publish(lottoNumbersGenerateStrategy)

        assertThat(lotto.numbers.numbers).isEqualTo(listOf(1, 2, 3, 4, 5, 6))
    }
}
