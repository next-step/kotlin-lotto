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

    @Test
    fun `당첨된 숫자가 6개를 초과하면 예외가 발생한다`() {
        shouldThrow<IllegalArgumentException> { Rank.from(7) }
            .shouldHaveMessage(Rank.INVALID_MATCHED_COUNT_MESSAGE)
    }
}
