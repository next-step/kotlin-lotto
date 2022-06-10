package lotto.entity

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class MatcherImplTest {

    @Test
    fun `matchOneTicket 당첨번호가 1,2,3,4,5,6 이고 로또 번호가 1,2,3,4,9,8인 경우 4개가 매칭된다`() {
        // given
        val winningNumbers = listOf<Int>(1, 2, 3, 4, 5, 6)
        val lottoNumbers = listOf<Int>(1, 2, 3, 4, 9, 8)
        val ticket = LottoTicket(lottoNumbers)

        // when
        val matchingResult = MatcherImpl(winningNumbers).matchOneTicket(ticket)

        // then
        Assertions.assertThat(matchingResult).isEqualTo(4)
    }

    @Test
    fun `matchAllTickets 한 번에 여러개를 매칭할 수 있다`() {
        // given
        val winningNumbers = listOf<Int>(1, 2, 3, 4, 5, 6)
        val firstLottoNumbers = listOf<Int>(1, 2, 11, 12, 13, 14)
        val secondLottoNumbers = listOf<Int>(1, 2, 3, 4, 5, 21)
        val firstTicket = LottoTicket(firstLottoNumbers)
        val secondTicket = LottoTicket(secondLottoNumbers)
        val tickets = listOf<LottoTicket>(firstTicket, secondTicket)

        // when
        val matchingResultList = MatcherImpl(winningNumbers).matchAllTickets(tickets)

        // then
        Assertions.assertThat(matchingResultList).isEqualTo(listOf(2, 5))
    }
}
