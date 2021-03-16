package lotto.result

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class PrizeRankTest {

    @ParameterizedTest
    @CsvSource("0,FAIL","3,FOURTH","4,THIRD","5,SECOND","6,FIRST")
    fun `맞은 갯수로 당첨금을 지급받는다`(matchCount:Int,prizeRank: PrizeRank) {
        assertThat(PrizeRank.ofMatchCount(matchCount)).isEqualTo(prizeRank)
    }
}