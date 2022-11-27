package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class RankTest {
    @ParameterizedTest
    @CsvSource(
        "1,false,MISS",
        "3,false,FIFTH",
        "4,true,FOURTH",
        "5,false,THIRD",
        "5,true,SECOND",
        "6,false,FIRST",
        "0,true, MISS"
    )
    fun `번호 일치 갯수에 따른 로또 등수를 반환한다`(countOfMatch: Int, matchBonus: Boolean, place: String) {
        assertThat(Rank.valueOf(countOfMatch, matchBonus)).isEqualTo(Rank.valueOf(place))
    }
}
