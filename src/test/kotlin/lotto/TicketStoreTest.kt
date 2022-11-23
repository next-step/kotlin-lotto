package lotto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

internal class TicketStoreTest {

    @CsvSource(value = ["1000:1", "14000:14"], delimiter = ':')
    @ParameterizedTest
    internal fun `로또 티켓 구매가 된다`(inputMoney: Int, expectedSize: Int) {
        // given
        // when
        val lottoTickets = TicketStore.buyTicket(inputMoney)

        // then
        assertThat(lottoTickets.tickets).hasSize(expectedSize)
    }

    @ValueSource(ints = [900, 12100])
    @ParameterizedTest
    internal fun `로또 티켓 가격보다 낮거나, 잔금이 남으면 구매가 실패한다`(input: Int) {
        // given

        // when, then
        assertThatIllegalArgumentException().isThrownBy { TicketStore.buyTicket(input) }
    }
}
