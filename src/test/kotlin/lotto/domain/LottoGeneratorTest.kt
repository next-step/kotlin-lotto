package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoGeneratorTest {
    @Test
    fun `특정 규칙으로 로또를 발행할 수 있다`() {
        val lottoGenerateStrategy = LottoGenerateStrategy {
            listOf(1, 2, 3, 4, 5, 6)
        }

        val generator = LottoGenerator(lottoGenerateStrategy)
        val lotto = generator.publish()

        assertThat(lotto).isEqualTo(Lotto(listOf(1, 2, 3, 4, 5, 6)))
    }
}
