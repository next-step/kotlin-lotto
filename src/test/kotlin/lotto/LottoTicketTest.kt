package lotto

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class LottoTicketTest {

    @Test
    fun `로또번호 매칭된 갯수를 확인한다`() {
        val lottoTicket = LottoTicket(listOf(1, 2, 3, 4, 5, 6))
        val otherTicket = LottoTicket(listOf(4, 5, 6, 7, 8, 9))

        val matchCount = lottoTicket.matchCountWith(otherTicket)
        val expectedCount = 3

        Assertions.assertThat(matchCount).isEqualTo(expectedCount)
    }
}
