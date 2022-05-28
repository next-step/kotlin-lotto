package lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTicketTest {
    @Test
    fun `로또는 6개의 숫자다`() {
        assertThrows<IllegalArgumentException> {
            LottoTicket(listOf(LottoNumber(1)))
        }
    }
}
