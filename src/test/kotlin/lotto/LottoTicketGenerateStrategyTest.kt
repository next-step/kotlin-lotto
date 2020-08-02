package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTicketGenerateStrategyTest {

    @Test
    fun `원하는 로또 번호를 가지는 티켓을 발급하는지 확인`() {
        // given
        val lottoNumbers = listOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(6)
        )
        val expectedLottoTicket = LottoTicket(lottoNumbers)
        val randomLottoTicketGenerator = object : LottoTicketGenerateStrategy {
            override fun createAutoTicket(): LottoTicket {
                return expectedLottoTicket
            }
        }

        // then
        assertThat(randomLottoTicketGenerator.createAutoTicket())
            .isEqualTo(expectedLottoTicket)
    }
}
