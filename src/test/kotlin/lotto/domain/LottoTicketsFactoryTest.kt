package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@Suppress("NonAsciiCharacters")
class LottoTicketsFactoryTest {

    @ParameterizedTest
    @ValueSource(ints = [1, 3, 10])
    fun `주어진 갯수만큼의 티켓을 만든다`(count: Int) {
        // when
        val tickets = LottoTicketsFactory.create(LottoTicketCount(count))

        // then
        assertThat(tickets.tickets.size).isEqualTo(count)
    }

    @Test
    fun `로또 티켓 input이 주어지면 LottoTickets로 변환한다`() {
        // given
        val inputs = listOf(
            "1, 2, 3, 4, 5,6",
            "40,41 ,42,43,44,45",
        )

        // when
        val tickets = LottoTicketsFactory.convertToTickets(inputs)

        // then
        assertThat(tickets.tickets.size).isEqualTo(2)
        assertThat(tickets.tickets[0])
            .usingRecursiveComparison()
            .isEqualTo(LottoNumbers(listOf(1, 2, 3, 4, 5, 6)))
    }
}
