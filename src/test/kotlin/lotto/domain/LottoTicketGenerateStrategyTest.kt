package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class LottoTicketGenerateStrategyTest {

    @Test
    fun `원하는 로또 번호를 가지는 티켓을 발급하는지 확인`() {
        // given
        val lottoNumbers = intArrayOf(1, 2, 3, 4, 5, 6)
        val expectedLottoTicket = LottoTicket(*lottoNumbers)
        val randomLottoTicketGenerator = object : LottoTicketGenerateStrategy {
            override fun createAutoTicket(): LottoTicket {
                return expectedLottoTicket
            }

            override fun createManualTicket(numbers: IntArray): LottoTicket {
                return expectedLottoTicket
            }
        }

        // then
        assertAll(
            {
                assertThat(randomLottoTicketGenerator.createAutoTicket())
                    .isEqualTo(expectedLottoTicket)
            },
            {
                assertThat(randomLottoTicketGenerator.createManualTicket(lottoNumbers))
                    .isEqualTo(expectedLottoTicket)
            }
        )
    }
}
