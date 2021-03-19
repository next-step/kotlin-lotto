package lotto.result

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class RankTest {

    @ParameterizedTest
    @CsvSource("0,FAIL", "3,FOURTH", "4,THIRD", "5,SECOND", "6,FIRST")
    fun `맞은 갯수로 당첨금을 지급받는다`(matchCount: Int, rank: Rank) {
        assertThat(Rank.ofMatchCount(matchCount)).isEqualTo(rank)
    }

    @Test
    fun `5개 일치-보너스볼 당첨시 이등 보너스 랭크`() {
        assertThat(Rank.ofMatchInfo(matchCount = 5, hasBonusBall = true)).isEqualTo(Rank.BONUS_SECOND)
    }
}
