package lotto.domain

import lotto.domain.value.HitLotto
import lotto.domain.value.LottoNumber
import lotto.domain.value.Money
import lotto.strategy.TestStrategy
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CustomerTest {
    private val winningNumbers = List(6) { i -> LottoNumber(i + 1) }
    private val testStrategy = TestStrategy()
    private val customer = Customer(Money(14500.toBigInteger()), testStrategy)

    @Test
    fun getCount() {
        assertThat(customer.count).isEqualTo(14)
    }

    @Test
    fun buyLotto() {
        val actual = customer.buyLotto()
        val expect = List(14) { Lotto(testStrategy) }
        assertThat(actual).isEqualTo(expect)
    }

    @Test
    fun hitLottos() {
        val actual = customer.hitLottos(winningNumbers)
        val expect = List(14) { HitLotto }

        assertThat(actual.size).isEqualTo(14)
        assertThat(actual).contains(HitLotto.SIX)
    }

    @Test
    fun countLottos() {
        val hitLottos = customer.hitLottos(winningNumbers)
        val resultList = customer.countLottos(hitLottos)
        assertThat(resultList.last()).isEqualTo(HitLotto.SIX)
    }

    @Test
    fun getTotalRate() {
        val hitLottos = customer.hitLottos(winningNumbers)
        customer.countLottos(hitLottos)
        val actual = customer.getTotalRate()
        val expect = HitLotto.SIX.money * 14 / 14500.toBigDecimal()
        assertThat(actual).isEqualTo(expect)
    }
}
