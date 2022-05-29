package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

@DisplayName("로또 상금")
internal class LottoPrizeTest {

    @ParameterizedTest(name = "맞은 개수: {0}, 순위: {1}, 상금: {2}")
    @CsvSource(
        "6,FIRST,2_000_000_000",
        "5,SECOND,1_500_000",
        "4,THIRD,50_000",
        "3,FOURTH,5_000",
        "2,MISS,0",
        "1,MISS,0",
        "0,MISS,0",
    )
    fun `맞은 개수에 따른 보상 반환`(matchedCount: Int, lottoPrize: LottoPrize, money: Int) {
        val prize = LottoPrize.getPrize(matchedCount)
        assertThat(prize).isEqualTo(lottoPrize)
        assertThat(prize.money).isEqualTo(money)
    }
}
