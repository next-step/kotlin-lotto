package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.within
import org.junit.jupiter.api.Test

@Suppress("NonAsciiCharacters")
class LottoStatisticsTest {

    @Test
    fun `티켓들과 당첨번호로부터 생성`() {
        // given
        val tickets = listOf(
            LottoNumbers(listOf(1, 2, 3, 4, 5, 6)),
            LottoNumbers(listOf(1, 2, 3, 4, 5, 6)),
            LottoNumbers(listOf(1, 2, 3, 4, 5, 45)),
            LottoNumbers(listOf(2, 3, 4, 5, 6, 7)),
            LottoNumbers(listOf(3, 4, 5, 6, 7, 8)),
            LottoNumbers(listOf(5, 6, 7, 8, 9, 10)),
            LottoNumbers(listOf(6, 7, 8, 9, 10, 11)),
            LottoNumbers(listOf(7, 8, 9, 10, 11, 12)),
        )
        val winning = WinningNumbers(LottoNumbers(listOf(1, 2, 3, 4, 5, 6)), LottoNumber(45))

        // when
        val result = LottoStatistics.from(LottoTickets(tickets), winning)

        // then
        val expected = mapOf(
            LottoRanking.RANK_1 to 2,
            LottoRanking.RANK_2 to 1,
            LottoRanking.RANK_3 to 1,
            LottoRanking.RANK_4 to 1,
            LottoRanking.RANK_5 to 0,
            LottoRanking.NO_RANK to 3,
        )
        assertThat(result.countByRanking).isEqualTo(expected)
    }

    @Test
    fun `수익률 계산`() {
        // given
        val countByRanking = mapOf(
            LottoRanking.RANK_5 to 1,
            LottoRanking.NO_RANK to 13,
        )
        val statistics = LottoStatistics(countByRanking)

        // when
        val result = statistics.revenue

        // then
        assertThat(result).isEqualTo(0.357, within(0.001))
    }
}
