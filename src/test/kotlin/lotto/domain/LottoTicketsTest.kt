package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

@Suppress("NonAsciiCharacters")
class LottoTicketsTest {

    @Test
    fun `티켓의 갯수를 센다`() {
        // given
        val tickets = listOf(
            LottoNumbers(listOf(1, 2, 3, 4, 5, 6)),
            LottoNumbers(listOf(1, 2, 3, 4, 5, 6)),
            LottoNumbers(listOf(1, 2, 3, 4, 5, 6)),
        )
        val lottoTickets = LottoTickets(tickets)

        // when
        val result = lottoTickets.count()

        // then
        assertThat(result.value).isEqualTo(tickets.count())
    }

    @Test
    fun `주어진 당첨 번호에 대하여 당첨 갯수를 구한다`() {
        // given
        val tickets = listOf(
            LottoNumbers(listOf(1, 2, 3, 4, 5, 6)),
            LottoNumbers(listOf(1, 2, 3, 4, 5, 6)),
            LottoNumbers(listOf(2, 3, 4, 5, 6, 7)),
            LottoNumbers(listOf(3, 4, 5, 6, 7, 8)),
            LottoNumbers(listOf(5, 6, 7, 8, 9, 10)),
            LottoNumbers(listOf(6, 7, 8, 9, 10, 11)),
            LottoNumbers(listOf(7, 8, 9, 10, 11, 12)),
        )
        val winning = LottoNumbers(listOf(1, 2, 3, 4, 5, 6))
        val lottoTickets = LottoTickets(tickets)

        // when
        val result = lottoTickets.countRankingFrom(winning)

        val expected = mapOf(
            LottoRanking.RANK_1 to 2,
            LottoRanking.RANK_2 to 1,
            LottoRanking.RANK_3 to 1,
            LottoRanking.NO_RANK to 3,
        )
        assertThat(result).isEqualTo(expected)
    }
}
