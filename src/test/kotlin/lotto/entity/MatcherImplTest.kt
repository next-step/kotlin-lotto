package lotto.entity

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class MatcherImplTest {

    @Test
    fun `matchOneTicket 당첨번호가 listOf(1,2,3,4,5,6) 이고 로또 번호가 listOf(1,2,3,4,9,8)인 경우 4개가 매칭된다`() {
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
    fun `matchAllTickets 2개 5개가 맞는 티켓을 한 번에 매칭하면 listOf(2,5)가 나온다`() {
        // given
        val winningNumbers = listOf<Int>(1, 2, 3, 4, 5, 6)
        val twoMatchingLottoNumbers = listOf<Int>(1, 2, 11, 12, 13, 14)
        val fiveMatchingLottoNumbers = listOf<Int>(1, 2, 3, 4, 5, 21)
        val twoMatchingTicket = LottoTicket(twoMatchingLottoNumbers)
        val fiveMatchingTicket = LottoTicket(fiveMatchingLottoNumbers)
        val tickets = listOf<LottoTicket>(twoMatchingTicket, fiveMatchingTicket)

        // when
        val matchingResultList = MatcherImpl(winningNumbers).matchAllTickets(tickets)

        // then
        Assertions.assertThat(matchingResultList).isEqualTo(listOf(2, 5))
    }

    @Test
    fun `matchTicketsToRanks 2개 5개 4개 일치하는 티켓이 있다면 mapOf(3 to 0, 4 to 1, 5 to 1, 6 to 0)를 리턴한다`() {
        // given
        val winningNumbers = listOf<Int>(1, 2, 3, 4, 5, 6)
        val firstLottoNumbers = listOf<Int>(1, 2, 11, 12, 13, 14) // 2개 일치
        val secondLottoNumbers = listOf<Int>(1, 2, 3, 4, 5, 21) // 5개 일치
        val thirdLottoNumbers = listOf<Int>(3, 4, 5, 6, 7, 8) // 4개 일치

        val firstTicket = LottoTicket(firstLottoNumbers)
        val secondTicket = LottoTicket(secondLottoNumbers)
        val thirdTicket = LottoTicket(thirdLottoNumbers)

        val tickets = listOf<LottoTicket>(firstTicket, secondTicket, thirdTicket)
        val expectedRanks = mapOf(3 to 0, 4 to 1, 5 to 1, 6 to 0)

        // when
        val winningRanks = MatcherImpl(winningNumbers).matchTicketsToRanks(tickets)

        // then
        Assertions.assertThat(winningRanks).isEqualTo(expectedRanks)
    }
}
