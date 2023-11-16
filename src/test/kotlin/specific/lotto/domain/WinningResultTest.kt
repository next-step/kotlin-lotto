package specific.lotto.domain

import hasDuplicate
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class WinningResultTest {

    @ParameterizedTest
    @CsvSource(
        "1|2|10|11|12|13,1|2|3|4|5|6",
        "1|2|3|11|12|13,1|2|3|4|5|6",
        "1|2|3|4|12|13,1|2|3|4|5|6",
        "1|2|3|4|5|13,1|2|3|4|5|6",
        "1|2|3|4|5|6,1|2|3|4|5|6",
    )
    fun `로또 번호와 당첨 번호가 3개 이상 같으면 당첨이다`(ticketValues: String, winningNumberValues: String) {
        // given
        val ticket = Ticket(LottoNumber(ticketValues.split("|").map { it.toInt() }))
        val winningNumber = WinningNumber(LottoNumber(winningNumberValues.split("|").map { it.toInt() }))

        // when
        val countOfSameNumber = WinningResult.countSameNumber(ticket, winningNumber)

        // then
        when(countOfSameNumber) {
            0, 1, 2 -> assertNull(WinningResult.Rank.getRank(countOfSameNumber))
            else -> assertNotNull(WinningResult.Rank.getRank(countOfSameNumber))
        }
    }

    @Test
    fun `당첨자는 로또 번호와 당첨 번호가 같은 개수에 따라 등수에 맞는 상금을 받는다`() {
        // given
        val countOfSameNumbers = listOf(3, 4, 5, 6)

        // when
        val prizes = countOfSameNumbers.map { WinningResult.Rank.getRank(it) }
            .filterNotNull()
            .map { it.prize }

        // then
        assertFalse(prizes.hasDuplicate())
    }

    fun `당첨 결과들은 등수별로 집계된다`() {
        // given
        val tickets = listOf<Ticket>(
            Ticket(LottoNumber(listOf(1, 2, 3, 4, 5, 6))),
            Ticket(LottoNumber(listOf(1, 2, 3, 4, 5, 12))),
            Ticket(LottoNumber(listOf(1, 2, 3, 4, 11, 12))),
            Ticket(LottoNumber(listOf(1, 2, 3, 10, 11, 12))),
        )
        val winningNumber = WinningNumber(LottoNumber(listOf(1, 2, 3, 4, 5, 6)))

        // when
        val winningResult = WinningResult(tickets, winningNumber)

        // then
        WinningResult.Rank.values().forEach {
            assertEquals(1, winningResult.aggregatedData[it])
        }
    }

}
