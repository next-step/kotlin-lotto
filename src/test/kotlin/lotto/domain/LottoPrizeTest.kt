package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

@DisplayName("로또 상금")
internal class LottoPrizeTest {

    @ParameterizedTest(name = "맞은 개수: {0}, 순위: {1}, 상금: {2}")
    @CsvSource(
        "6,FIRST,2_000_000_000,false",
        "5,SECOND,30_000_000,true",
        "5,THIRD,1_500_000,false",
        "4,FOURTH,50_000,false",
        "3,FIFTH,5_000,false",
        "2,MISS,0,false",
        "1,MISS,0,false",
        "0,MISS,0,false",
    )
    fun `맞은 개수에 따른 보상 반환`(matchedCount: Int, lottoPrize: LottoPrize, money: Int, bonus: Boolean) {
        val prize = LottoPrize.getPrize(matchedCount, bonus)
        assertThat(prize).isEqualTo(lottoPrize)
        assertThat(prize.money).isEqualTo(money)
    }
}
