package lotto.domain

import lotto.domain.value.Money
import lotto.domain.value.WinLotto
import lotto.strategy.TestStrategy
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CustomerTest {
    val won = 14500
    val customer = Customer(Money(won), TestStrategy())

    @Test
    fun `생성자 만큼의 돈을 가지고 있음`() {
        assertThat(customer.getMoney()).isEqualTo(Money(won))
    }

    @Test
    fun `투입한 돈 나누기 1000의 몫 만큼의 개수를 구매`() {
        assertThat(customer.count).isEqualTo(14)
    }

    @Test
    fun `로또의 총 수익금 계산`() {
        assertThat(customer.getTotalMoney()).isEqualTo(WinLotto.SIX.money * customer.count)
    }

    @Test
    fun `총 수익율 계산`() {
        assertThat(customer.getTotalRate()).isEqualTo(100.0)
    }
}
