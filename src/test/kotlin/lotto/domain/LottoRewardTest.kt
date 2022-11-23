package lotto.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.matchers.ints.shouldBeGreaterThanOrEqual
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LottoRewardTest {

    @DisplayName("맞춘 번호 개수가 3개 이상이면 당첨 금액이 계산된다")
    @ParameterizedTest
    @ValueSource(
        ints = [3, 4, 5, 6]
    )
    fun reward(input: Int) {
        val reward = LottoReward.reward(matchCount = input)
        reward shouldBeGreaterThanOrEqual FOURTH_WIN_PRICE
    }

    @DisplayName("맞춘 번호 개수가 2개 이하이면 당첨금이 없다")
    @ParameterizedTest
    @ValueSource(
        ints = [0, 1, 2]
    )
    fun zero(input: Int) {
        val reward = LottoReward.reward(matchCount = input)
        reward shouldBe 0
    }

    @DisplayName("맞춘 번호 개수는 음수 또는 6개를 초과 할 수 없다.")
    @ParameterizedTest
    @ValueSource(
        ints = [-1, 7]
    )
    fun minusOrOverCount(input: Int) {
        shouldThrowExactly<IllegalStateException> {
            LottoReward.reward(matchCount = input)
        }
    }
}
