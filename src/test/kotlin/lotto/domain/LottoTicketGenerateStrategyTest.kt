package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTicketGenerateStrategyTest {

    @Test
    fun `원하는 로또 번호를 가지는 티켓을 발급하는지 확인`() {
        // given
        val expectedLottoTicket = LottoTicket(1, 2, 3, 4, 5, 6)
        val randomLottoTicketGenerator = object : LottoTicketGenerateStrategy {
            override fun createAutoTicket(): LottoTicket {
                return expectedLottoTicket
            }

            override fun createManualTicket(numbers: List<Int>): LottoTicket {
                return expectedLottoTicket
            }
        }

        // then
        assertThat(randomLottoTicketGenerator.createAutoTicket())
            .isEqualTo(expectedLottoTicket)
    }
}
