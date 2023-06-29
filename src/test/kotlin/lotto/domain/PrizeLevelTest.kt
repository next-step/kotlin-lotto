package lotto.domain

import lotto.dto.LottoMatchResult
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class PrizeLevelTest {

    @Test
    fun `로또 번호가 맞은 갯수를 가지고 등수를 계산한다`() {
        val listOfNumberOfHit = listOf(1, 3, 1, 6)

        val actual = listOfNumberOfHit.map { PrizeLevel.fromNumberOfHit(it) }

        val answer = listOf(
            PrizeLevel.NONE,
            PrizeLevel.FIFTH,
            PrizeLevel.NONE,
            PrizeLevel.FIRST
        )
        Assertions.assertThat(actual).isEqualTo(answer)
    }

    @Test
    fun `로또 등수 리스트를 입력받아서 통계를 낸다`() {
        val listOfPrizeLevel = listOf(
            PrizeLevel.NONE,
            PrizeLevel.FOURTH,
            PrizeLevel.NONE,
            PrizeLevel.FIRST,
            PrizeLevel.FIRST,
            PrizeLevel.SECOND
        )

        val actual = LottoMatchResult.countPrizeLevels(listOfPrizeLevel)
        val answer = mapOf(
            PrizeLevel.FIRST to 2,
            PrizeLevel.SECOND to 1,
            PrizeLevel.FOURTH to 1
        )

        Assertions.assertThat(actual).isEqualTo(answer)
    }
}
