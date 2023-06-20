package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class RankTest {
    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2])
    fun `당첨된 숫자가 3개 미만이면 LOSE다`(matchedCount: Int) {
        Rank.from(matchedCount) shouldBe Rank.LOSE
    }

    @ParameterizedTest
    @ValueSource(ints = [7, -1])
    fun `일치하는 숫자가 0개에서 6개가 아니라면 예외가 발생한다`(matchedCount: Int) {
        shouldThrow<IllegalArgumentException> { Rank.from(matchedCount) }
            .shouldHaveMessage(Rank.INVALID_MATCHED_COUNT_MESSAGE.format(matchedCount))
    }
}
