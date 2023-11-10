package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class PurchaseTest {

    @ParameterizedTest
    @CsvSource(value = ["1000|1", "2000|2", "11000|11"], delimiter = '|')
    fun `구입금액을 기준으로 구매수량을 반환한다`(
        amount: Int,
        expectQuantity: Int,
    ) {
        // Given
        val purchase = Purchase(amount)

        // When
        val actual = purchase.quantity()

        // Then
        assertThat(actual).isEqualTo(expectQuantity)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, -1000, 1100, 111, -111])
    fun `구입금액이 0이하 이거나 1000원단위가 아닌 경우 에러를 반환한다`(
        amount: Int
    ) {
        assertThrows<IllegalArgumentException> {
            Purchase(amount)
        }
    }
}