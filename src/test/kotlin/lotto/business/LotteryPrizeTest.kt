package lotto.business

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LotteryPrizeTest {
    @ParameterizedTest
    @CsvSource(value = ["6,FIRST", "5,THIRD", "4,FOURTH", "3,FIFTH", "2,MISS", "1,MISS", "0,MISS"])
    fun `매칭 개수로 당첨 등수를 구한다`(matchCount: Int, expected: LotteryPrize) {
        // when
        val result = LotteryPrize.getPrize(matchCount)

        // then
        assertThat(result).isEqualTo(expected)
    }
}
