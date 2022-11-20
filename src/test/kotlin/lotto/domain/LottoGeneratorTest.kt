package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoGeneratorTest {
    @Test
    fun generateLottoNumbers() {
        val resultLotto = LottoGenerator.generateLottoNumbers()

        assertThat(resultLotto.count()).isEqualTo(6)
        resultLotto.forEach { number ->
            assertThat(number).isBetween(1, 45)
        }
    }
}
