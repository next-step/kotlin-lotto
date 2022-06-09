package lotto.domain.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
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

    @Test
    fun `zero를 통해서 값이 0인 PurchaseCount를 얻을 수 있다`() {
        assertThat(PurchaseCount.zero()).isEqualTo(PurchaseCount.from(0))
    }

    @Test
    fun `빼기 연산자를 사용해 빼기 연산을 수행할 수 있다`() {
        val count1 = PurchaseCount.from(10)
        val count2 = PurchaseCount.from(5)

        assertThat(count1 - count2).isEqualTo(PurchaseCount.from(5))
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 100, 30])
    fun `coerceAtMost를 통해 특정 최댓값을 넘지 못하도록 제한할 수 있다`(input: Int) {
        val maximum = 20
        val expected = if (input > maximum) maximum else input
        val purchaseCount = PurchaseCount.from(input).coerceAtMost(PurchaseCount.from(maximum))

        assertThat(purchaseCount.value).isEqualTo(expected)
    }
}
