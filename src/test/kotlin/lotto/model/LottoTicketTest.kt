package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoTicketTest {
    @Test
    fun `LottoTicket 은 생성될때 6자리의 번호가 자동 으로 생성된다`() {
        val lottoTicket = LottoTicket()

        assertThat(lottoTicket.candidateNumbers.size).isEqualTo(6)
    }
}
