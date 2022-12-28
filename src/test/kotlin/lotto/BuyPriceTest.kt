package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BuyPriceTest {

    @Test
    fun `sut price over 1_000`() {
        // Arrange
        val price = 2_000

        // Act
        val sut = BuyPrice(price)

        // Assert
        assertThat(sut.price).isEqualTo(price)
    }

    @Test
    fun `sut price under 1_000`() {
        // Arrange
        val price = 900

        // Act & Assert
        assertThrows<IllegalArgumentException> { BuyPrice(price) }
    }
}