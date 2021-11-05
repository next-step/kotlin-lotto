package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoPrizeTest {
    @ParameterizedTest
    @CsvSource("3|FORTH", "4|THIRD", "5|SECOND", "6|FIRST")
    fun `일치된 번호 개수로 LottoPrize 를 가져올 수 있다`(input: Int, expectedPrize: LottoPrize) {
        val prize = LottoPrize.fromMatchCount(input)
        assertThat(prize).isEqualTo(expectedPrize)
    }
}
