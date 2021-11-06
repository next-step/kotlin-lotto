package lotto.domain

import org.assertj.core.api.Assertions.assertThat
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
}
