package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class AwardTest {

    @ParameterizedTest
    @CsvSource(value = ["0:NON_PLACE", "1:NON_PLACE", "2:NON_PLACE", "3:FIFTH_PLACE", "4:FOURTH_PLACE", "6:FIRST_PLACE"], delimiter = ':')
    internal fun `5개 일치하는 번호를 제외하고 1~6 번호는 보너스번호 결과에 무관하게 결과를 반환한다`(matchCount: Int, expected: Award) {
        assertThat(Award.of(matchCount, false)).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource(value = ["false:THIRD_PLACE", "true:SECOND_PLACE"], delimiter = ':')
    internal fun `5개의 번호가 일치하고 보너스번호일치에 따라 결과가 달라진다`(matchBonus: Boolean, expected: Award) {
        // given
        val matchCount = 5

        // when, then
        assertThat(Award.of(matchCount, matchBonus)).isEqualTo(expected)
    }
}
