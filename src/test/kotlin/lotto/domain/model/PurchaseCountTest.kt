package lotto.domain.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class PurchaseCountTest {
    private val price = Money.from(1_000)

    @ParameterizedTest
    @ValueSource(ints = [1, 100, 30])
    fun `PurchaseCount는 로또 구입 개수를 나타내며, Int를 보관한다`(input: Int) {
        val purchaseCount = PurchaseCount.from(input)

        assertThat(purchaseCount.value).isEqualTo(input)
    }

    @ParameterizedTest
    @ValueSource(ints = [1, -100, 30, -5000])
    fun `0보다 작은 값을 전달받을 경우, 0으로 저장한다`(input: Int) {
        val purchaseCount = PurchaseCount.from(input)

        assertThat(purchaseCount.value).isGreaterThanOrEqualTo(0)
    }

    @ParameterizedTest
    @CsvSource(value = ["10000,10", "11500,11", "2432,2", "500,0"], delimiter = ',')
    fun `총 구입 금액과 가격을 받아 PurchaseCount를 얻을 수 있다`(purchaseAmount: Int, expected: Int) {
        val purchaseCount = PurchaseCount.of(
            purchaseAmount = Money.from(purchaseAmount),
            price = price
        )

        assertThat(purchaseCount.value).isEqualTo(expected)
    }
}
