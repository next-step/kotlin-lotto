package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTicketTest {
    @Test
    fun `로또 번호 개수는 6개`() {
        assertThat(LottoTicket.generateByAuto().numbers.size).isEqualTo(6)
    }
}
