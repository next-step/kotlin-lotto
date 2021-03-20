package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class MoneyTest {

    private lateinit var money: Money

    @BeforeEach
    fun init() {
        money = Money(10000)
    }

    @Test
    fun `3000원을 소비하고 잔액 확인`() {
        money.spendMoney(3000)
        assertThat(money.currentMoney).isEqualTo(7000)
    }

    @Test
    fun `모든 돈을 다 써버리고 잔액 확인`() {
        money.spendAllMoney()
        assertThat(money.currentMoney).isEqualTo(0)
    }

    @Test
    fun `돈을 일부 사용한 다음 남은 돈을 모두 사용한다`() {
        money.spendMoney(3000)
        money.spendAllMoney()
        assertThat(money.currentMoney).isEqualTo(0)
    }

    @Test
    fun `구매 가능한 수량 출력`() {
        val quantity = money.getQuantityOfAvailablePurchase()
        assertThat(quantity).isEqualTo(10)
    }

    @Test
    fun `사용하려는 금액이 가진 금액보다 많을경우 Exception발생`() {
        assertThrows<IllegalStateException> { money.spendMoney(11000) }
    }

    @Test
    fun `초기 생성시 금액을 0보다 작게 설정할 때 Exception발생`() {
        assertThrows<IllegalArgumentException> { Money(-1000) }
    }
}
