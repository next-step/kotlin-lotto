package lottery.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource
import org.junit.jupiter.params.provider.ValueSource

class RankTest {

    @ParameterizedTest
    @EnumSource(Rank::class)
    @DisplayName("매칭 횟수에 따라 순위가 결정된다")
    fun matchResult(rank: Rank) {
        val result = Rank.of(rank.countOfMatch)

        result shouldBe rank
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2])
    @DisplayName("3개 미만인 경우 미당첨이다")
    fun mismatchResult(countOfMatch: Int) {
        val result = Rank.of(countOfMatch)

        result shouldBe Rank.MISS
    }

}