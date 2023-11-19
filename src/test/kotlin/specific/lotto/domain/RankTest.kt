package specific.lotto.domain

import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class RankTest {

    @ParameterizedTest
    @CsvSource(
        "1|2|3|4|5|6,1|2|3|4|5|6",
        "1|2|3|4|5|20,1|2|3|4|5|6",
        "1|2|3|4|19|20,1|2|3|4|5|6",
        "1|2|3|18|19|20,1|2|3|4|5|6",
    )
    fun `로또 번호와 당첨 번호가 3개 이상 같으면 당첨이다`(ticketInput: String, winningSetInput: String) {
        // given
        val ticket = Ticket(ticketInput.split("|").map { it.toInt() }.map { Number(it) }.toSet())
        val winningSet = WinningSet(winningSetInput.split("|").map { it.toInt() }.map { Number(it) }.toSet())

        // when
        val rank = Rank.decideRank(ticket, winningSet)

        // then
        assertNotEquals(Rank.NO_WIN, rank)
    }
}
