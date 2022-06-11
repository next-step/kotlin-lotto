package lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class LottoTicketTest {

    @Test
    fun `로또 6자리 확인`() {
        assertThrows<IllegalArgumentException> { LottoTicket(listOf(1, 2, 3, 4, 5, 6, 7).map { LottoNumber(it) }) }
    }
}
