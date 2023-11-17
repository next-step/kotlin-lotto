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
    fun `매칭 횟수에 따라 순위가 결정된다`(rank: Rank) {
        val matchBonus = rank == Rank.SECOND
        val result = Rank.of(rank.countOfMatch, matchBonus)

        result shouldBe rank
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2])
    fun `매치 개수가 3개 미만인 경우 미당첨이다`(countOfMatch: Int) {
        val result = Rank.of(countOfMatch)

        result shouldBe Rank.MISS
    }
}
