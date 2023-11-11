package lotto.business

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LotteryPrizeTest {
    @ParameterizedTest
    @CsvSource(
        value = [
            "6,true,FIRST",
            "5,true,SECOND",
            "5,false,THIRD",
            "4,true,FOURTH",
            "3,true,FIFTH",
            "2,true,MISS",
            "1,true,MISS",
            "0,true,MISS"
        ]
    )
    fun `매칭 개수로 당첨 등수를 구한다`(matchCount: Int, contains: Boolean, expected: LotteryPrize) {
        // when
        val result = LotteryPrize.getPrize(matchCount, contains)

        // then
        assertThat(result).isEqualTo(expected)
    }
}
