package lotto.domain

import lotto.enums.Rank
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class LotteryResultTest {

    @Test
    fun `구매한 로또들의 당첨 결과를 알 수 있다`() {
        // Given
        val givenAmount = 6000
        val matchCounts = listOf(3, 0, 0, 0, 0, 0)
        val actual = LotteryResult.from(Rank.excludeNoneRankOfRecord())

        // When
        actual.makeRankResult(givenAmount, matchCounts)

        // Then
        val expected = makeExpectedRecords()
        assertAll(
            { assertThat(actual.rankRecord).isEqualTo(expected) },
            { assertThat(actual.rate).isEqualTo(0.83) },
        )
    }

    private fun makeExpectedRecords(): Set<Record> {
        val expected = Rank.excludeNoneRankOfRecord()
        expected.filter {
            it.matchCount == 3
        }.map {
            it.addCountByRecord(3)
        }
        return expected
    }
}
