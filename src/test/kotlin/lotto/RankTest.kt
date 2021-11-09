package lotto

import lotto.domain.Rank
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class RankTest {

    @DisplayName(value = "6개 당첨이면 1등이다.")
    @Test
    fun `6개 당첨이면 1등이다`() {
        assertThat(Rank.rankByMatchCount(6, false)).isEqualTo(Rank.FIRST)
    }

    @DisplayName(value = "5개 당첨에 BonusBall을 맞췄으면 2등이다")
    @Test
    fun `5개 당첨에 BonusBall을 맞췄으면 2등이다`() {
        assertThat(Rank.rankByMatchCount(5, true)).isEqualTo(Rank.SECOND)
    }

    @DisplayName(value = "BonusBall 없이 5개 맞추면 3등이다.")
    @Test
    fun `BonusBall 없이 5개 맞추면 3등이다`() {
        assertThat(Rank.rankByMatchCount(5, false)).isEqualTo(Rank.THIRD)
    }

    @DisplayName(value = "BonusBall 없이 4개 맞추면 4등이다.")
    @Test
    fun `BonusBall 없이 4개 맞추면 4등이다`() {
        assertThat(Rank.rankByMatchCount(4, false)).isEqualTo(Rank.FOURTH)
    }

    @DisplayName(value = "BonusBall 없이 3개 맞추면 5등이다.")
    @Test
    fun `BonusBall 없이 3개 맞추면 5등이다`() {
        assertThat(Rank.rankByMatchCount(3, false)).isEqualTo(Rank.FIFTH)
    }

    @ParameterizedTest(name = "3개 미만 맞추면 꼴등이다.")
    @CsvSource(value = ["2, false", "1, false", "0, false"])
    fun `3개 미만 맞추면 꼴등이다`(value: Int, expected: Boolean) {
        assertThat(Rank.rankByMatchCount(value, false)).isEqualTo(Rank.MISS)
    }
}
