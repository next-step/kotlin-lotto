package view

import domain.money.Money
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class BuyingInputTest {
    @ParameterizedTest
    @ValueSource(ints = [1, 1500, Int.MAX_VALUE])
    fun `구매금액입력값은 돈으로 변환할 수 있다`(amount: Int) {
        assertThat(BuyingInput(amount).toMoney()).isEqualTo(Money(amount))
    }
}
