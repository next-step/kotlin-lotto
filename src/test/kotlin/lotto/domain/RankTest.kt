package lotto.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class RankTest {

    @DisplayName("당첨 숫자 6개를 맞춘 경우 1등이다.")
    @Test
    fun first() {
        val matchCount = 6
        val matchBonus = false

        val result = Rank.safeValueOf(matchCount, matchBonus)

        result shouldBe Rank.FIRST_GRADE
    }

    @DisplayName("당첨 숫자가 5개이고 보너스 숫자를 맞춘 경우 2등이다.")
    @Test
    fun second() {
        val matchCount = 5
        val matchBonus = true

        val result = Rank.safeValueOf(matchCount, matchBonus)

        result shouldBe Rank.SECOND_GRADE
    }

    @DisplayName("당첨 숫자가 5개를 맞춘 경우 3등이다.")
    @Test
    fun third() {
        val matchCount = 5
        val matchBonus = false

        val result = Rank.safeValueOf(matchCount, matchBonus)

        result shouldBe Rank.THIRD_GRADE
    }

    @DisplayName("당첨 숫자가 4개를 맞춘 경우 4등이다.")
    @Test
    fun four() {
        val matchCount = 4
        val matchBonus = false

        val result = Rank.safeValueOf(matchCount, matchBonus)

        result shouldBe Rank.FOURTH_GRADE
    }

    @DisplayName("당첨 숫자가 3개를 맞춘 경우 5등이다.")
    @Test
    fun five() {
        val matchCount = 3
        val matchBonus = false

        val result = Rank.safeValueOf(matchCount, matchBonus)

        result shouldBe Rank.FIFTH_GRADE
    }

    @DisplayName("당첨 숫자가 2개 이하를 맞춘 경우는 없다.")
    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2])
    fun none(matchCount: Int) {
        val matchBonus = false

        val result = Rank.safeValueOf(matchCount, matchBonus)

        result shouldBe Rank.NO_MATCH
    }
}
