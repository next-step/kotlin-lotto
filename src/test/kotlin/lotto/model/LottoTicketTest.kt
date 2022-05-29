package lotto.model

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

internal class LottoTicketTest {

    @Test
    internal fun `로또티켓을 랜덤으로 생성 가능하다`() {
        assertDoesNotThrow { LottoTicket.new() }
    }

    @Test
    internal fun `로또 티켓의 숫자가 6개가 아닌 경우 IllegalArgumentException 에러 발생`() {
        assertThrows<IllegalArgumentException> {
            LottoTicket(
                setOf(
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3)
                )
            )
        }
    }
}
