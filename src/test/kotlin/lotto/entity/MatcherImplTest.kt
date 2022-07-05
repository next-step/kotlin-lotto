package lotto.entity

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class MatcherImplTest {

    @Test
    fun `4개의 숫자가 맞고 보너스 볼이 맞지 않은 경우 4등을 한다`() {
        // given
        val winningNumbers = listOf<Int>(1, 2, 3, 4, 5, 6)
        val bonus = 12
        val lottoNumber = LottoNumber(winningNumbers, bonus)
        val userLottoNumber = listOf<Int>(1, 2, 3, 4, 9, 8)
        val ticket = LottoTicket(userLottoNumber)

        // when
        val matchingResult = MatcherImpl(lottoNumber).matchOneTicket(ticket)

        // then
        Assertions.assertThat(matchingResult).isEqualTo(Rank.FOURTH)
    }

    @Test
    fun `4개의 숫자가 맞고 보너스 볼이 맞는 경우 4등을 한다`() {
        // given
        val winningNumbers = listOf<Int>(1, 2, 3, 4, 5, 6)
        val bonus = 8
        val lottoNumber = LottoNumber(winningNumbers, bonus)
        val userLottoNumber = listOf<Int>(1, 2, 3, 4, 9, 8)
        val ticket = LottoTicket(userLottoNumber)

        // when
        val matchingResult = MatcherImpl(lottoNumber).matchOneTicket(ticket)

        // then
        Assertions.assertThat(matchingResult).isEqualTo(Rank.FOURTH)
    }

    @Test
    fun `5개의 숫자가 맞고 보너스 볼이 맞지 않는 경우 3등을 한다`() {
        // given
        val winningNumbers = listOf<Int>(1, 2, 3, 4, 5, 6)
        val bonus = 12
        val lottoNumber = LottoNumber(winningNumbers, bonus)
        val userLottoNumber = listOf<Int>(1, 2, 3, 4, 5, 8)
        val ticket = LottoTicket(userLottoNumber)

        // when
        val matchingResult = MatcherImpl(lottoNumber).matchOneTicket(ticket)

        // then
        Assertions.assertThat(matchingResult).isEqualTo(Rank.THIRD)
    }

    @Test
    fun `5개의 숫자가 맞고 보너스 볼이 맞는 경우 2등을 한다`() {
        // given
        val winningNumbers = listOf<Int>(1, 2, 3, 4, 5, 6)
        val bonus = 8
        val lottoNumber = LottoNumber(winningNumbers, bonus)
        val userLottoNumber = listOf<Int>(1, 2, 3, 4, 5, 8)
        val ticket = LottoTicket(userLottoNumber)

        // when
        val matchingResult = MatcherImpl(lottoNumber).matchOneTicket(ticket)

        // then
        Assertions.assertThat(matchingResult).isEqualTo(Rank.SECOND)
    }

    @Test
    fun `2개 5개가 맞는 티켓을 한 번에 매칭하면 3등, 맞지 않는 결과가 나온다`() {
        // given
        val winningNumbers = listOf<Int>(1, 2, 3, 4, 5, 6)
        val bonus = 12
        val lottoNumber = LottoNumber(winningNumbers, bonus)

        val twoMatchingLottoNumbers = listOf<Int>(1, 2, 11, 12, 13, 14)
        val fiveMatchingLottoNumbers = listOf<Int>(1, 2, 3, 4, 5, 21)

        val twoMatchingTicket = LottoTicket(twoMatchingLottoNumbers)
        val fiveMatchingTicket = LottoTicket(fiveMatchingLottoNumbers)

        val tickets = listOf<LottoTicket>(twoMatchingTicket, fiveMatchingTicket)

        val expectedList = listOf(Rank.MISS, Rank.THIRD)

        // when
        val matchingResultList = MatcherImpl(lottoNumber).matchAllTickets(tickets)

        // then
        Assertions.assertThat(matchingResultList).isEqualTo(expectedList)
    }

    @Test
    fun `matchTicketsToRanks 함수 - 2개 5개 4개 일치하는 티켓이 있다면 mapOf(3 to 0, 4 to 1, 5 to 1, 6 to 0)를 리턴한다`() {
        // given
        val winningNumbers = listOf<Int>(1, 2, 3, 4, 5, 6)
        val bonus = 12
        val lottoNumber = LottoNumber(winningNumbers, bonus)

        val firstLottoNumbers = listOf<Int>(1, 2, 11, 12, 13, 14) // 2개 일치
        val secondLottoNumbers = listOf<Int>(1, 2, 3, 4, 5, 21) // 5개 일치
        val thirdLottoNumbers = listOf<Int>(3, 4, 5, 6, 7, 8) // 4개 일치

        val firstTicket = LottoTicket(firstLottoNumbers)
        val secondTicket = LottoTicket(secondLottoNumbers)
        val thirdTicket = LottoTicket(thirdLottoNumbers)

        val tickets = listOf<LottoTicket>(firstTicket, secondTicket, thirdTicket)
        val wallet = Wallet(0, tickets)
        val expectedRanks = mapOf(Rank.FIFTH to 0, Rank.FOURTH to 1, Rank.THIRD to 1, Rank.SECOND to 0, Rank.FIRST to 0)

        // when
        val winningRanks = MatcherImpl(lottoNumber).countTicketRanks(wallet).countOfRanks

        // then
        Assertions.assertThat(winningRanks).isEqualTo(expectedRanks)
    }
}
