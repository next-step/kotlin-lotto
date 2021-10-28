package lotto.domain

import lotto.exception.InvalidLottoPriceException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

@DisplayName("구입 금액 테스트")
class PriceTest {

    @ParameterizedTest
    @CsvSource(value = ["1000,1", "3000,3", "14000,14"])
    @DisplayName("로또 1장의 가격은 1000원이다. 1000원 단위로 n장의 로또를 구매할 수 있다")
    fun `sut returns correctly`(price: String, expected: String) {
        // Arrange
        val value = price.toInt()

        // Act
        val sut = Price(value)
        val result = sut.checkLottoCount()

        // Assert
        assertThat(result).isEqualTo(expected.toInt())
    }

    @Test
    @DisplayName("로또 구입 금액이 1000원 단위로 나누어 떨어지지 않을 경우 예외 발생")
    fun `sut throw IllegalArgumentException when Price is not divide`() {
        // Act, Assert
        assertThrows<InvalidLottoPriceException> { Price(1500) }
    }
}
