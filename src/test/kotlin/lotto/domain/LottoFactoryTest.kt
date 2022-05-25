package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

/**
 * Created by Jaesungchi on 2022.05.25..
 */
class LottoFactoryTest {
    @Test
    internal fun `로또 번호 6개를 자동 발행한다`() {
        assertThat(LottoFactory.getRandomLottoTicket().numbers.size).isEqualTo(6)
    }

    @Test
    internal fun `로또번호 발행은 번호 순으로 출력한다`() {
        val ticket = LottoFactory.getRandomLottoTicket()
        val sortTicketNumbers = ticket.numbers.sorted()
        assertThat(ticket.numbers).isEqualTo(sortTicketNumbers)
    }

    @Test
    internal fun `로또번호는 중복이 되면 안된다`() {
        val ticket = LottoFactory.getRandomLottoTicket()
        val distinctTicketNumbers = ticket.numbers.distinct()
        assertThat(ticket.numbers).isEqualTo(distinctTicketNumbers)
    }
}
