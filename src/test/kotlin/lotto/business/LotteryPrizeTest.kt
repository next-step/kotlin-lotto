package lotto.business

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LotteryPrizeTest {
    @ParameterizedTest
    @CsvSource(value = ["6,SIX_MATCH", "5,FIVE_MATCH", "4,FOUR_MATCH", "3,THREE_MATCH", "2,NONE", "1,NONE", "0,NONE"])
    fun `매칭 개수로 당첨 등수를 구한다`(matchCount: Int, expected: LotteryPrize) {
        // when
        val result = LotteryPrize.getPrize(matchCount)

        // then
        assertThat(result).isEqualTo(expected)
    }
}
