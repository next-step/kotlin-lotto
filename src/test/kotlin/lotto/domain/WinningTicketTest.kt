package lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class WinningTicketTest {

    @Test
    internal fun `보너스볼 숫자가 로또번호에도 들어있으면 에러가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            WinningTicket(Lotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }), 6)
        }
    }
}
