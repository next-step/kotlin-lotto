package camp.nextstep.lotto.raffle

import camp.nextstep.lotto.IntArrayConverter
import camp.nextstep.lotto.ticket.LottoTicket
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.converter.ConvertWith
import org.junit.jupiter.params.provider.CsvSource

internal class LottoResultMatcherTest {

    @DisplayName("당첨 번호가 [1, 2, 3, 4, 5, 6] 일 때,")
    @ParameterizedTest(name = "로또 티켓이 {0} 이면 {1} 개가 일치한다.")
    @CsvSource(
        delimiter = '|',
        value = [
            "1, 2, 3, 4, 5, 6|6",
            "1, 2, 3, 4, 5, 10|5",
            "11, 22, 3, 4, 5, 6|4",
            "11, 2, 3, 4, 41, 43|3",
            "11, 12, 13, 14, 5, 6|2",
            "11, 12, 13, 14, 15, 6|1",
            "11, 12, 13, 14, 15, 16|0"
        ]
    )
    fun matchedLottoNumbers(@ConvertWith(IntArrayConverter::class) ticketNumbers: IntArray, expectedMatchCount: Int) {
        val lottoTicket = LottoTicket(ticketNumbers.toList())

        val matchedCount = LottoResultMatcher.count(lottoTicket, listOf(1, 2, 3, 4, 5, 6))

        assertEquals(expectedMatchCount, matchedCount)
    }

    @DisplayName("여러 개의 티켓에 대하여 일치하는 개수를 기준으로 계산할 수 있다.")
    @Test
    fun calculateLottoTickets() {
        val tickets = listOf(
            LottoTicket(listOf(1, 2, 3, 4, 5, 6)), // 6
            LottoTicket(listOf(10, 2, 3, 4, 5, 6)), // 5
            LottoTicket(listOf(1, 2, 3, 41, 5, 6)), // 5
            LottoTicket(listOf(12, 22, 31, 4, 5, 6)), // 3
            LottoTicket(listOf(16, 26, 35, 4, 5, 6)), // 3
            LottoTicket(listOf(13, 23, 32, 41, 5, 6)), // 2
            LottoTicket(listOf(17, 27, 36, 41, 5, 6)), // 2
            LottoTicket(listOf(18, 28, 37, 41, 5, 6)), // 2
            LottoTicket(listOf(14, 24, 33, 41, 45, 6)), // 1
            LottoTicket(listOf(15, 25, 34, 41, 44, 45)), // 0
        )
        val winnerNumbers = listOf(1, 2, 3, 4, 5, 6)

        val winningTickets = LottoResultMatcher.winningTickets(tickets, winnerNumbers)

        assertThat(winningTickets.filter { it.winnings == Winnings.SIX }).hasSize(1)
        assertThat(winningTickets.filter { it.winnings == Winnings.FIVE }).hasSize(2)
        assertThat(winningTickets.filter { it.winnings == Winnings.FOUR }).hasSize(0)
        assertThat(winningTickets.filter { it.winnings == Winnings.THREE }).hasSize(2)
    }
}
