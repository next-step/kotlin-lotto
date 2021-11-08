package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class LottoPrizeTest {
    @ParameterizedTest
    @CsvSource("3,false,FIFTH", "4,false,FOURTH", "5,false,THIRD", "5,true,SECOND", "6,false,FIRST")
    fun `일치된 번호 개수로 LottoPrize 를 가져올 수 있다`(input: Int, bonusMatch: Boolean, expectedPrize: LottoPrize) {
        val prize = LottoPrize.fromMatchCount(input, bonusMatch)
        assertThat(prize).isEqualTo(expectedPrize)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2])
    fun `정해진 상금이 없는 경우 null 을 반환한다`(matchCount: Int) {
        val prize = LottoPrize.fromMatchCount(matchCount)
        assertThat(prize).isNull()
    }
}
