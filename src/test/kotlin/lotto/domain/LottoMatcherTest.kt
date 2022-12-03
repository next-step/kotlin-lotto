package lotto.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.matchers.ints.shouldBeGreaterThanOrEqual
import io.kotest.matchers.shouldBe
import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LottoMatcherTest {

    @DisplayName("당첨 된 숫자 개수를 확인한다")
    @Test
    fun matchingCount() {
        val numbers: List<Int> = listOf(8, 21, 23, 41, 42, 43)
        val list: List<Int> = listOf(9, 21, 27, 41, 42, 45)

        assertThat(LottoMatcher.countMatchNumber(winningNumbers = numbers, lottoNumbers = list)).isEqualTo(3)
    }

    @DisplayName("맞춘 번호 개수가 3개인 경우 상금은 ${50_000}")
    @Test
    fun correctThreeNumbers() {
        val reward = LottoMatcher.matchingWinner(matchCount = 3, matchBonus = false)
        reward.prize shouldBeGreaterThanOrEqual 50_000
    }

    @DisplayName("맞춘 번호 개수가 4개인 경우 상금은 ${1_500_000}")
    @Test
    fun correctFourNumbers() {
        val reward = LottoMatcher.matchingWinner(matchCount = 4, matchBonus = false)
        reward.prize shouldBeGreaterThanOrEqual 1_500_000
    }

    @DisplayName("맞춘 번호 개수가 5개인 경우 상금은 ${30_000_000}")
    @Test
    fun correctFiveNumbers() {
        val reward = LottoMatcher.matchingWinner(matchCount = 5, matchBonus = false)
        reward.prize shouldBeGreaterThanOrEqual 30_000_000
    }

    @DisplayName("맞춘 번호 개수가 6개인 경우 상금은 ${2_000_000_000}")
    @Test
    fun correctSixNumbers() {
        val reward = LottoMatcher.matchingWinner(matchCount = 6, matchBonus = false)
        reward.prize shouldBeGreaterThanOrEqual 2_000_000_000
    }

    @DisplayName("맞춘 번호 개수가 2개 이하이면 당첨금이 없다")
    @ParameterizedTest
    @ValueSource(
        ints = [0, 1, 2]
    )
    fun zero(input: Int) {
        val reward = LottoMatcher.matchingWinner(matchCount = input, matchBonus = false)
        reward.prize shouldBe 0
    }

    @DisplayName("맞춘 번호 개수는 음수 또는 6개를 초과 할 수 없다.")
    @ParameterizedTest
    @ValueSource(
        ints = [-1, 7]
    )
    fun minusOrOverCount(input: Int) {
        shouldThrowExactly<IllegalStateException> {
            LottoMatcher.matchingWinner(matchCount = input, matchBonus = false)
        }
    }
}
