package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoPrizeTest {
    @CsvSource("5, false, THIRD", "5, true, SECOND", "0, false, MISS")
    @ParameterizedTest
    fun `맞힌 갯수에 따라 로또 등수를 반환한다`(matchCount: Int, matchBonus: Boolean, prize: String) {
        Assertions.assertThat(LottoPrize.from(matchCount, matchBonus).toString()).isEqualTo(prize)
    }
}
