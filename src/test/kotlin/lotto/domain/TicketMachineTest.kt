package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

@DisplayName("티켓 발행")
internal class TicketMachineTest {

    @ParameterizedTest(name = "구매 금액={0}, 구매 개수={1}")
    @CsvSource(
        "1000,1",
        "2222,2",
        "3333,3",
        "4999,4",
    )
    fun `정상 구매`(amount: Int, expected: Int) {
        // given
        val ticketMachine = TicketMachine()

        // when
        val tickets = ticketMachine.buy(amount)

        // then
        assertThat(tickets).hasSize(expected)
    }

    @ParameterizedTest(name = "구매 금액={0}")
    @ValueSource(ints = [-1000, 999, 100])
    fun `구매 금액이 음수거나 한개도 못사는 경우`(amount: Int) {
        // given
        val ticketMachine = TicketMachine()

        // when
        val tickets = ticketMachine.buy(amount)

        // then
        assertThat(tickets).hasSize(0)
    }
}
