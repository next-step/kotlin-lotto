package lotto.domain

import lotto.domain.LottoNumber
import lotto.domain.LottoResult
import lotto.domain.LottoShop
import lotto.domain.LottoTicket
import lotto.domain.LottoTicketGenerateStrategy
import lotto.domain.LottoTicketGenerator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoShopTest {

    @Test
    fun `원하는 개수만큼의 티켓을 발급하는지 확인`() {
        // given
        val ticketCount = 10
        val lottoShop = LottoShop(LottoTicketGenerator())

        // then
        assertThat(lottoShop.getAutoTickets(10_000)).hasSize(ticketCount)
    }

    @Test
    fun `행운 숫자와 비교해서 모든 로또 결과 구하기`() {
        // given
        val lottoNumbers = listOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(6)
        )
        val lottoTicket = LottoTicket(lottoNumbers)
        val lottoShop = LottoShop(object : LottoTicketGenerateStrategy {
            override fun createAutoTicket(): LottoTicket {
                return lottoTicket
            }

            override fun createManualTicket(numbers: List<Int>): LottoTicket {
                return LottoTicket(lottoNumbers)
            }
        })
        lottoShop.setLuckyLottoNumbers(listOf(1, 2, 3, 4, 5, 6))
        val expectedLottoResults =
            listOf(LottoResult.FIRST, LottoResult.FIRST, LottoResult.FIRST, LottoResult.FIRST, LottoResult.FIRST)

        // when
        val lottoTickets = lottoShop.getAutoTickets(5_000)
        val lottoResults = lottoShop.getLottoResultsOf(lottoTickets)

        // then
        assertThat(lottoResults).isEqualTo(expectedLottoResults)
    }
}
