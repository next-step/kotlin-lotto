package lottery.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class LotteryMatcherTest {
    @Test
    fun `로또번호들 중에 당첨번호와 일치하는 개수들을 전달한다`() {
        val lotteries = listOf(
            createLottery(listOf(1, 3, 5, 2, 9, 40)),
            createLottery(listOf(34, 24, 1, 15, 3, 5)),
            createLottery(listOf(3, 1, 5, 15, 24, 40)),
            createLottery(listOf(1, 3, 5, 40, 24, 15))
        )

        val winnerLottery = WinnerLottery(listOf(1, 3, 5, 24, 15, 40))

        val lotteryMatcher = LotteryMatcher(winnerLottery, lotteries)

        val matchCounts = lotteryMatcher.match(BonusBall(10, winnerLottery))

        assertAll(
            { Assertions.assertThat(matchCounts.retrieve(Rank.FOURTH)).isEqualTo(1) },
            { Assertions.assertThat(matchCounts.retrieve(Rank.THIRD)).isEqualTo(1) },
            { Assertions.assertThat(matchCounts.retrieve(Rank.FIRST)).isEqualTo(2) }
        )
    }

    private fun createLottery(numbers: List<Int>) = Lottery(LotteryNumbers(numbers))
}
