package lotto.domain

import lotto.domain.value.LottoNumber
import lotto.domain.value.Money
import lotto.strategy.TestStrategy
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CustomerTest {
    val testStrategy = TestStrategy()
    val customer = Customer(Money(14500.toBigInteger()), testStrategy)

    @Test
    fun getCount() {
        assertThat(customer.count).isEqualTo(14)
    }

    @Test
    fun buyLotto() {
        val actual = customer.buyLotto()
        // 테스트를 위해 Lotto를 data class로 변경했는데
        // 번호가 같다고 같은 로또라고 할 수는 없다고 생각됩니다.
        // 이럴 경우 어떤식으로 처리해야 할까요?
        val expect = List(14) { Lotto(testStrategy) }
        assertThat(actual).isEqualTo(expect)
    }

    @Test
    fun winLottoCount() {
        val winningNumbers = List(6) { i -> LottoNumber(i + 1) }
        val actual = customer.winLottoCount(winningNumbers)
        assertThat(actual.any { it.getCount() > 0 }).isTrue()
    }

    @Test
    fun getTotalRate() {
        // TODO customer2가 만들어졌을 때 enum이 초기화가 안됨... count를 빼자
        val customer2 = Customer(Money(15500.toBigInteger()), testStrategy)
        val winningNumbers = List(6) { i -> LottoNumber(i + 1) }
        customer2.winLottoCount(winningNumbers)
        assertThat(customer2.getTotalRate()).isEqualTo(
            2_000_000_000.toBigDecimal().multiply(15.toBigDecimal()) / 15500.toBigDecimal()
        )
    }
}
