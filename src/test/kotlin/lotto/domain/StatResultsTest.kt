package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StatResultsTest {
    @Test
    fun `로또티켓 당첨번호 수익금으로 수익률을 확인한다`() {
        val receipt = Receipt(14_0000)
        val statResults = listOf(
            StatResult(MatchState.MATCH_3, 2, MatchState.MATCH_3.profit * 2),
            StatResult(MatchState.MATCH_4, 1, MatchState.MATCH_4.profit * 1)
        )
        val expect = 0.43
        val yield = StatResults(statResults).yield(receipt)
        assertThat(`yield`).isEqualTo(expect)
    }
}
