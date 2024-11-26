package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class RankTest {
    @ParameterizedTest
    @CsvSource(
        "6, false, FIRST",
        "5, false, THIRD",
        "4, false, FOURTH",
        "3, false, FIFTH",
    )
    fun `당첨은 일치갯수와 추가번호 일치여부로 판단한다`(
        matchCount: Int,
        isBonus: Boolean,
        expected: Rank,
    ) {
        val rank = Rank.match(matchCount, isBonus)

        assertThat(rank).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource(
        "5, true, SECOND",
        "5, false, THIRD",
    )
    fun `2등은 보너스번호를 추가 확인한다`(
        matchCount: Int,
        isBonus: Boolean,
        expected: Rank,
    ) {
        val rank = Rank.match(matchCount, isBonus)

        assertThat(rank).isEqualTo(expected)
    }

    @Test
    fun `prizeRanks 상금목록을 알수 있다`() {
        val prizeRanks = Rank.prizeRanks

        assertThat(prizeRanks).contains(
            Rank.FIRST,
            Rank.SECOND,
            Rank.THIRD,
            Rank.FOURTH,
        )
    }
}
