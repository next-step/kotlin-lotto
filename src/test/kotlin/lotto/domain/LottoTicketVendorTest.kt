package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTicketVendorTest {
    @Test
    fun `입력한 로또 수 만큼 Lotto 객체가 생성된다`() {
        // given
        // when
        val lottoTickets = LottoVendor.generate(3)
        // then
        assertThat(lottoTickets.lottoTickets.size).isEqualTo(3)
    }
}
