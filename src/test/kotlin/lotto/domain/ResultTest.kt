package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResultTest {

    @Test
    fun `모든 순위 당첨 결과를 리턴한다`() {
        val givenRecord = mapOf(Reward.FIRST to 2, Reward.SECOND to 3)

        val actual = Result.EMPTY.updateRewards(givenRecord)

        assertThat(actual.result.values).containsExactly(2, 3, 0, 0, 0)
    }

    @Test
    fun `당첨액을 리턴한다`() {
        val givenRecord = mapOf(Reward.THIRD to 1, Reward.FOURTH to 1)

        val actual = Result.EMPTY.updateRewards(givenRecord)

        assertThat(actual.getTotalAmount()).isEqualTo(55000)
    }

    @Test
    fun `수익률을 리턴한다`() {
        val givenRecord = mapOf(Reward.FOURTH to 1)
        val budget = Budget.valueOf(14000)

        val actual = Result(givenRecord).getProfit(budget)

        assertThat(actual).isEqualTo(0.35)
    }
}
