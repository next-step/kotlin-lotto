package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoNumberGeneratorTest {
    private val sut = LottoNumberGenerator

    @Test
    fun `sut generate lotto numbers by count`() {
        // Arrange
        val lottoCount = 10
        // Act
        val lottos = sut.generate(lottoCount)

        // Assert
        assertThat(lottos.size).isEqualTo(lottoCount)
    }

    @Test
    fun `sut generate lotto 6 numbers`() {
        // Arrange

        // Act
        val lotto = sut.generate(1)

        // Assert
        assertThat(lotto.first().numbers.size).isEqualTo(6)
    }

    @Test
    fun `sut generate lotto numbers in 1 to 45`() {
        // Arrange

        // Act
        val lotto = sut.generate(1)

        // Assert
        lotto.first().numbers.forEach {
            assertThat(1..45).contains(it)
        }
    }
}
