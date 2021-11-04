package lotto.domain

import lotto.domain.strategy.MockLottoGenerator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class LottoMachineTest {

    @ParameterizedTest
    @CsvSource(value = ["10000, 10", "20000, 20", "0, 0"])
    fun `주어진 예산으로 구매 가능한 로또 개수를 계산할 수 있다`(budget: Int, count: Int) {
        // given
        val machine = LottoMachine(MockLottoGenerator)
        val userBudget = Money.of(budget)

        // when
        val totalCount = machine.count(userBudget)

        // then
        assertThat(totalCount).isEqualTo(count)
    }

    @ParameterizedTest
    @ValueSource(ints = [10, 20, 30, 50, 0])
    fun `주어진 개수만큼의 로또를 구매할 수 있다`(count: Int) {
        // given
        val machine = LottoMachine(MockLottoGenerator)

        // when
        val lotteries = machine.buy(count)

        // then
        assertThat(lotteries.values.size).isEqualTo(count)
    }
}
