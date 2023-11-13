package lotto.domain

import lotto.enums.Rank
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class LotteryResultTest {

    @Test
    fun `구매한 로또들의 당첨 결과를 알 수 있다`() {
        // Given
        val winning = Lotto.from(listOf(1, 2, 3, 33, 34, 35))
        val userLottos = listOf(
            Lotto.from(listOf(1, 2, 3, 4, 5, 6)),
            Lotto.from(listOf(7, 12, 13, 14, 15, 16)),
            Lotto.from(listOf(1, 2, 13, 14, 5, 16)),
            Lotto.from(listOf(41, 42, 43, 14, 15, 16)),
            Lotto.from(listOf(31, 12, 32, 24, 15, 16)),
            Lotto.from(listOf(11, 12, 31, 41, 15, 16)),
        )
        val lotteryResult = LotteryResult.of(winning, userLottos)

        // When
        val actual = lotteryResult.makeRankResult(6000)

        // Then
        val expected = makeExpectedRecords()
        assertAll(
            { assertThat(actual.records).isEqualTo(expected) },
            { assertThat(actual.rate).isEqualTo(0.83) },
        )
    }

    private fun makeExpectedRecords(): List<Record> {
        val expected = Rank.records()
        expected.filter {
            it.matchCount == 3
        }.map {
            it.addCountByRecord(3)
        }
        return expected
    }
}