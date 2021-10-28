package lotto.domain

import lotto.exception.IllegalPurchaseException
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

internal class PurchaseTest {
    @DisplayName("구매 금액은 음수일 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = [-11, -1])
    fun `잘못된 구입 금액`(purchasePrice: Int) {
        assertThatExceptionOfType(IllegalPurchaseException::class.java)
            .isThrownBy { Purchase(purchasePrice) }
    }

    @DisplayName("로또 가격을 1000 으로 하여 수량을 계산해야한다.")
    @ParameterizedTest
    @CsvSource("999,0", "46000,46", "12345,12")
    fun `수량 계산`(purchasePrice: Int, expectedQuantity: Int) {
        assertThat(Purchase(purchasePrice).calculateQuantity())
            .isEqualTo(expectedQuantity)
    }
}
