package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RandomNumberGeneratorTest {

    @Test
    fun `로또 번호 6개를 생성하여 리턴한다`() {
        val generatedNumber = RandomNumberGenerator().generateNumbers()

        assertThat(generatedNumber).hasSize(6)
    }
}
