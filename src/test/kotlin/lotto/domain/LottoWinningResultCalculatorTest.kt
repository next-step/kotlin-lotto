package lotto.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.matchers.ints.shouldBeGreaterThanOrEqual
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LottoWinningResultCalculatorTest {

    @DisplayName("맞춘 번호 개수가 3개인 경우 상금은 $FOURTH_WIN_PRICE")
    @Test
    fun correctThreeNumbers() {
        val reward = LottoRewardCalculator.calculate(matchingCount = 3)
        reward.prize shouldBeGreaterThanOrEqual FOURTH_WIN_PRICE
    }

    @DisplayName("맞춘 번호 개수가 4개인 경우 상금은 $THIRD_WIN_PRICE")
    @Test
    fun correctFourNumbers() {
        val reward = LottoRewardCalculator.calculate(matchingCount = 4)
        reward.prize shouldBeGreaterThanOrEqual THIRD_WIN_PRICE
    }

    @DisplayName("맞춘 번호 개수가 5개인 경우 상금은 $SECOND_WIN_PRICE")
    @Test
    fun correctFiveNumbers() {
        val reward = LottoRewardCalculator.calculate(matchingCount = 5)
        reward.prize shouldBeGreaterThanOrEqual SECOND_WIN_PRICE
    }

    @DisplayName("맞춘 번호 개수가 6개인 경우 상금은 $FIRST_WIN_PRICE")
    @Test
    fun correctSixNumbers() {
        val reward = LottoRewardCalculator.calculate(matchingCount = 6)
        reward.prize shouldBeGreaterThanOrEqual FIRST_WIN_PRICE
    }

    @DisplayName("맞춘 번호 개수가 2개 이하이면 당첨금이 없다")
    @ParameterizedTest
    @ValueSource(
        ints = [0, 1, 2]
    )
    fun zero(input: Int) {
        val reward = LottoRewardCalculator.calculate(matchingCount = input)
        reward.prize shouldBe NONE_WIN_PRICE
    }

    @DisplayName("맞춘 번호 개수는 음수 또는 6개를 초과 할 수 없다.")
    @ParameterizedTest
    @ValueSource(
        ints = [-1, 7]
    )
    fun minusOrOverCount(input: Int) {
        shouldThrowExactly<IllegalStateException> {
            LottoRewardCalculator.calculate(matchingCount = input)
        }
    }
}
