package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MatchStatesTest {
    @Test
    fun `로또번호가 3개이상 일치하는 로또티켓별로 당첨번호개수와 당첨금액을 확인한다`() {
        val matchStates = listOf(
            MatchState.NOT_MATCH,
            MatchState.MATCH_4,
            MatchState.MATCH_4,
            MatchState.MATCH_5,
        )

        val expect = listOf(
            StatResult(MatchState.MATCH_3),
            StatResult(MatchState.MATCH_4, 2, MatchState.MATCH_4.profit * 2),
            StatResult(MatchState.MATCH_5, 1, MatchState.MATCH_5.profit * 1),
            StatResult(MatchState.MATCH_6)
        )
        val accumulateList = MatchStates(matchStates).accumulate()

        assertThat(accumulateList).isEqualTo(expect)
    }
    @Test
    fun `보너스번호로 2등 당첨을 확인한다`() {
        val matchStates = listOf(
            MatchState.NOT_MATCH,
            MatchState.MATCH_5_BONUS
        )

        val expect = listOf(
            StatResult(MatchState.MATCH_3),
            StatResult(MatchState.MATCH_4),
            StatResult(MatchState.MATCH_5),
            StatResult(MatchState.MATCH_5_BONUS, 1, MatchState.MATCH_5_BONUS.profit * 1),
            StatResult(MatchState.MATCH_6)
        )
        val accumulateList = MatchStates(matchStates).accumulate()

        assertThat(accumulateList).isEqualTo(expect)
    }
}
