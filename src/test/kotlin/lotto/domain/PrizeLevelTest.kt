package lotto.domain

import lotto.dto.MatchedCount
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class PrizeLevelTest {

    @Test
    fun `로또 번호가 맞은 갯수와 보너스 숫자 일치 여부를 가지고 등수를 판별한다`() {
        // given
        val listOfMatchedCount = listOf(
            MatchedCount(1, true),
            MatchedCount(1, false),
            MatchedCount(3, true),
            MatchedCount(3, false),
            MatchedCount(5, true),
            MatchedCount(5, false),
            MatchedCount(6, true),
            MatchedCount(6, false),
        )

        // when
        val actual = listOfMatchedCount.map { PrizeLevel.proceedLevel(it) }

        val answer = listOf(
            PrizeLevel.NONE,
            PrizeLevel.NONE,
            PrizeLevel.FIFTH,
            PrizeLevel.FIFTH,
            PrizeLevel.SECOND,
            PrizeLevel.THIRD,
            PrizeLevel.FIRST,
            PrizeLevel.FIRST
        )

        // then
        Assertions.assertThat(actual).isEqualTo(answer)
    }
}
