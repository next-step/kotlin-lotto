package lotto.application

import lotto.domain.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LotteryRandomGeneratorTest {

    @Test
    fun `LotteryRandomGenerator creates 6 numbers`() {
        val generatedNumbers = LotteryRandomGenerator.generate()

        assertThat(generatedNumbers).hasSize(Lotto.LOTTO_NUMBER_COUNT)
    }

    @Test
    fun `Random numbers should be in 1 ~ 45`() {
        val generatedNumbers = LotteryRandomGenerator.generate()

        assertThat(generatedNumbers).isSubsetOf(Lotto.LOTTO_NUMBER_RANGE)
    }
}
