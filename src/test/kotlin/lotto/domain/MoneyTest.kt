package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class MoneyTest {

    @ParameterizedTest
    @CsvSource(value = ["10000, 1000, 10", "20000, 200, 100", "1000, 10000, 0"])
    fun `구매가능한 티켓의 개수를 계산할 수 있다`(budget: Int, price: Int, count: Int) {
        // given
        val userBudget = Money.of(budget)
        val ticketPrice = Money.of(price)

        // when
        val totalCount = userBudget.count(ticketPrice)

        // then
        Assertions.assertThat(totalCount).isEqualTo(count)
    }
}
