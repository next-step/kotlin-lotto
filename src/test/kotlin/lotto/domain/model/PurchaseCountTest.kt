package lotto.domain.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class PurchaseCountTest {
    private val price = Money.from(1_000)

    @ParameterizedTest
    @CsvSource(value = ["10000,10", "11500,11", "2432,2", "500,0"], delimiter = ',')
    fun `PurchaseCount는 로또 구입 개수를 나타내며, Int를 보관한다`(purchaseAmount: Int, expected: Int) {
        val purchaseCount = PurchaseCount.of(
            purchaseAmount = Money.from(purchaseAmount),
            price = price
        )

        assertThat(purchaseCount.value).isEqualTo(expected)
    }
}
