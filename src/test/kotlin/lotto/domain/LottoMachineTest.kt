package lotto.domain

import lotto.domain.strategy.MockLottoNumberGenerator
import lotto.fixture.OrderFixture
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class LottoMachineTest {

    @ParameterizedTest
    @CsvSource(value = ["10000, 10", "20000, 20", "0, 0"])
    fun `주어진 예산으로 구매 가능한 로또 개수를 계산할 수 있다`(budget: Int, count: Int) {
        // given
        val machine = LottoMachine(MockLottoNumberGenerator)
        val userBudget = Money.from(budget)

        // when
        val totalCount = machine.count(userBudget)

        // then
        assertThat(totalCount).isEqualTo(count)
    }

    @ParameterizedTest
    @ValueSource(ints = [10, 20, 30, 50, 0])
    fun `주어진 개수만큼의 로또를 구매할 수 있다`(count: Int) {
        // given
        val machine = LottoMachine(MockLottoNumberGenerator)
        val order = OrderFixture.`주어진 개수 만큼 주문 내역 생성`(count)

        // when
        val lotteries = machine.buy(order)

        // then
        assertThat(lotteries.values.size).isEqualTo(count)
    }
}
