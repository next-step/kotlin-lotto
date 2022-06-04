package camp.nextstep.lotto.raffle

import camp.nextstep.lotto.IntArrayConverter
import camp.nextstep.lotto.number.LottoNumber
import camp.nextstep.lotto.number.LottoNumbers
import camp.nextstep.lotto.number.WinnerNumbers
import camp.nextstep.lotto.ticket.LottoTicket
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.converter.ConvertWith
import org.junit.jupiter.params.provider.CsvSource

internal class LottoResultMatcherTest {

    @DisplayName("당첨 번호가 [1, 2, 3, 4, 5, 6]이고 보너스 번호가 7일 때,")
    @ParameterizedTest(name = "로또 티켓이 {0} 이면 {1} 개가 일치하고 보너스 번호 일치 여부는 {2} 이다.")
    @CsvSource(
        delimiter = '|',
        value = [
            "1, 2, 3, 4, 5, 6|6|false",
            "1, 2, 3, 4, 5, 10|5|false",
            "1, 2, 3, 4, 5, 7|5|true",
            "11, 22, 3, 4, 5, 6|4|false",
            "11, 2, 3, 4, 41, 43|3|false",
            "11, 2, 3, 4, 7, 43|3|true",
            "11, 12, 13, 14, 5, 6|2|false",
            "11, 12, 13, 14, 15, 6|1|false",
            "11, 12, 7, 14, 15, 6|1|true",
            "11, 12, 13, 14, 15, 16|0|false"
        ]
    )
    fun matchedLottoNumbers(@ConvertWith(IntArrayConverter::class) ticketNumbers: IntArray, expectedMatchCount: Int, expectedMatchedBonus: Boolean) {
        val winnerNumbers = LottoNumbers.of(1, 2, 3, 4, 5, 6)
        val bonusNumber = LottoNumber.of(7)
        val lottoTicket = LottoTicket.of(ticketNumbers.map { LottoNumber.of(it) }.toList())

        val matchResult = LottoResultMatcher.count(lottoTicket, WinnerNumbers(winnerNumbers, bonusNumber))

        assertEquals(expectedMatchCount, matchResult.matchedCount)
    }

    @DisplayName("여러 개의 티켓에 대하여 일치하는 개수를 기준으로 계산할 수 있다.")
    @Test
    fun calculateLottoTickets() {
        val tickets = listOf(
            LottoTicket.of(1, 2, 3, 4, 5, 6), // 6
            LottoTicket.of(1, 2, 3, 4, 7, 6), // 5 + bonus
            LottoTicket.of(1, 2, 3, 7, 5, 6), // 5 + bonus
            LottoTicket.of(10, 2, 3, 4, 5, 6), // 5
            LottoTicket.of(1, 2, 3, 41, 5, 6), // 5
            LottoTicket.of(12, 22, 31, 4, 5, 6), // 3
            LottoTicket.of(16, 26, 35, 4, 5, 6), // 3
            LottoTicket.of(13, 23, 32, 41, 5, 6), // 2
            LottoTicket.of(17, 27, 36, 41, 5, 6), // 2
            LottoTicket.of(18, 28, 37, 41, 5, 6), // 2
            LottoTicket.of(14, 24, 33, 41, 45, 6), // 1
            LottoTicket.of(15, 25, 34, 41, 44, 45), // 0
        )
        val winnerNumbers = LottoNumbers.of(1, 2, 3, 4, 5, 6)
        val bonusNumber = LottoNumber.of(7)

        val winningTickets = LottoResultMatcher.winningTickets(tickets, WinnerNumbers(winnerNumbers, bonusNumber))

        assertThat(winningTickets.filter { it.winnings == Winnings.FIRST }).hasSize(1)
        assertThat(winningTickets.filter { it.winnings == Winnings.SECOND }).hasSize(2)
        assertThat(winningTickets.filter { it.winnings == Winnings.THIRD }).hasSize(2)
        assertThat(winningTickets.filter { it.winnings == Winnings.FOURTH }).hasSize(0)
        assertThat(winningTickets.filter { it.winnings == Winnings.FIFTH }).hasSize(2)
    }
}
