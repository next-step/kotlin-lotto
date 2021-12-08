package lotto.domain

import lotto.domain.LottoNumber.Companion.MAX_NUMBER
import lotto.domain.Ticket.Companion.LOTTO_NUMBER_COUNT
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class TicketTest {

    @Test
    fun `티켓 생성시 올바른 티켓 번호 검증`() {
        val ticketGenerator = TicketGenerator(FixNumberStrategy(listOf(1, 2, 3, 4, 5, 6)))
        val ticket = ticketGenerator.tickets(1000).tickets.first()
        assertTrue(ticket.numbers.map { it.number }.none { it > MAX_NUMBER })
        assertTrue(ticket.numbers.size == LOTTO_NUMBER_COUNT)
    }

    @ParameterizedTest
    @CsvSource(
        "1;2;3;4;5;6, 1;2;3;4;5;6, 7, FIRST",
        "1;2;3;4;5;6, 1;2;3;4;5;10, 10, SECOND",
        "1;2;3;4;5;6, 1;2;3;4;5;10, 7, THIRD",
        "1;2;3;4;5;6, 1;2;3;4;10;12, 7, FOURTH",
        "1;2;3;4;5;6, 1;2;3;10;11;12, 7, FIFTH",
        "1;2;3;4;5;6, 11;12;13;14;15;16, 7, NONE",
    )
    fun `rank 판단 검증`(
        winningNums: String,
        selectedNums: String,
        winningBonusNumber: String,
        rankName: String
    ) {

        // given
        val winningNumber = winningNums.split(";").map { it.toInt() }
        val selectedNumber = selectedNums.split(";").map { it.toInt() }
        val expectedRank = Rank.valueOf(rankName)
        val ticketGenerator = TicketGenerator(FixNumberStrategy(selectedNumber))

        // when
        val ticket = ticketGenerator.tickets(1000).tickets.first()
        val rank = ticket.getRank(winningNumber, winningBonusNumber.toInt())

        // then
        assertEquals(expectedRank, rank)
    }

}
