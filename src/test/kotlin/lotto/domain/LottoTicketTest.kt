package lotto.domain

import org.assertj.core.api.Assertions.assertThat
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
            LottoTicket(1, 2, 3)
        }
    }

    @Test
    internal fun `티켓 두 개의 번호를 비교하여 서로 같은 숫자의 개수를 반환한다`() {
        val lottoTicket1 = LottoTicket(1, 2, 3, 4, 5, 6)
        val lottoTicket2 = LottoTicket(1, 2, 3, 8, 9, 10)

        val actualResult = lottoTicket1.countIntersect(lottoTicket2)
        assertThat(actualResult).isEqualTo(3)
    }

    private fun LottoTicket(vararg numbers: Int) =
        LottoTicket(numbers.map { LottoNumber(it) }.toSet())
}
