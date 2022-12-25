package lotto.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.matchers.shouldBe
import lotto.domain.model.Lotto
import lotto.domain.model.LottoNumber
import lotto.domain.model.Rank
import lotto.domain.model.Winning
import org.assertj.core.api.AssertionsForClassTypes.assertThat
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

    @DisplayName("당첨 된 숫자 개수를 확인한다")
    @Test
    fun matchingCount() {
        val winning = Winning(Winning.makeLottoNumbers("8, 21, 23, 41, 42, 43"), LottoNumber(1))
        val lotto = Lotto(listOf(9, 21, 27, 41, 42, 45).map { LottoNumber(it) })

        assertThat(Rank.countMatchNumber(winning, lotto)).isEqualTo(3)
    }

    @DisplayName("5등 당첨금 확인")
    @Test
    fun fifthReward() {
        val reward = Rank.matchingWinner(matchCount = 3, matchBonus = false)
        reward.prize shouldBe 5_000
    }

    @DisplayName("4등 당첨금 확인")
    @Test
    fun fourthReward() {
        val reward = Rank.matchingWinner(matchCount = 4, matchBonus = false)
        reward.prize shouldBe 50_000
    }

    @DisplayName("3등 당첨금 확인")
    @Test
    fun thirdReward() {
        val reward = Rank.matchingWinner(matchCount = 5, matchBonus = false)
        reward.prize shouldBe 1_500_000
    }

    @DisplayName("2등 당첨금 확인")
    @Test
    fun secondReward() {
        val reward = Rank.matchingWinner(matchCount = 5, matchBonus = true)
        reward.prize shouldBe 30_000_000
    }

    @DisplayName("1등 당첨금 확인")
    @Test
    fun firstReward() {
        val reward = Rank.matchingWinner(matchCount = 6, matchBonus = false)
        reward.prize shouldBe 2_000_000_000
    }

    @DisplayName("맞춘 번호 개수가 2개 이하이면 당첨금이 없다")
    @ParameterizedTest
    @ValueSource(
        ints = [0, 1, 2]
    )
    fun zero(input: Int) {
        val reward = Rank.matchingWinner(matchCount = input, matchBonus = false)
        reward.prize shouldBe 0
    }

    @DisplayName("맞춘 번호 개수는 음수 또는 6개를 초과 할 수 없다.")
    @ParameterizedTest
    @ValueSource(
        ints = [-1, 7]
    )
    fun minusOrOverCount(input: Int) {
        shouldThrowExactly<IllegalStateException> {
            Rank.matchingWinner(matchCount = input, matchBonus = false)
        }
    }
}
