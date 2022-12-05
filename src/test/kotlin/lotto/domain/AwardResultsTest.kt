package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

internal class AwardResultsTest {

    @Test
    fun `상금을 반환한다`() {
        // given
        val awardResults = AwardResults(
            listOf(
                AwardResult(Award.FIFTH_PLACE, 1)
            ),
            1000
        )

        // when
        val profitability = awardResults.profitability()

        // then
        assertThat(profitability).isEqualTo(5.0)
    }

    @Test
    fun `대상 상금이 당첨된 티켓 수를 반환한다`() {
        // given
        val awardResults = AwardResults(
            listOf(
                AwardResult(Award.FIRST_PLACE, 3),
                AwardResult(Award.THIRD_PLACE, 2),
                AwardResult(Award.FOURTH_PLACE, 1)
            ),
            1000
        )
        // when, then
        assertAll(
            { assertThat(awardResults.matchCount(Award.FIRST_PLACE)).isEqualTo(3) },
            { assertThat(awardResults.matchCount(Award.THIRD_PLACE)).isEqualTo(2) },
            { assertThat(awardResults.matchCount(Award.FOURTH_PLACE)).isEqualTo(1) }
        )
    }
}
