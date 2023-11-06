package lotto.business

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTicketGeneratorTest {
    @Test
    fun `티켓을 생성한다`() {
        // given
        val lottoTicketGenerator = LottoTicketGenerator(RandomLottoPicker())

        // when
        val lottoTicket = lottoTicketGenerator.generateSingleTicket()

        // then
        assertThat(lottoTicket).isInstanceOf(LottoTicket::class.java)
    }

    @Test
    fun `티켓을 원하는 개수만큼 생성한다`() {
        // given
        val lottoTicketGenerator = LottoTicketGenerator(RandomLottoPicker())

        // when
        val lottoTickets = lottoTicketGenerator.generateMultipleTickets(3)

        // then
        assertThat(lottoTickets).hasSize(3)
    }
}
