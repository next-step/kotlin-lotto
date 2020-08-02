package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class BuyerTest {

    @ParameterizedTest
    @CsvSource(
        value = [
            "14000, 14",
            "13500, 13",
            "11222, 11"
        ]
    )
    fun `구매 금액에 따른 로또 갯수 확인`(price: Int, expected: Int) {
        assertThat(Buyer(price).purchaseCount).isEqualTo(expected)
    }
}
