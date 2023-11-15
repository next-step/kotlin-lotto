package lotto.domain

import lotto.enums.Rank
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource

class LottoRecordTest {

    @ParameterizedTest
    @MethodSource("matchRankProvider")
    fun `당첨 순위별 갯수를 지니는 당첨결과를 생성한다`(
        rank: Rank,
        quantity: Int,
    ) {
        // Given & When
        val actual = LottoRecord(rank, quantity)

        // Then
        assertAll(
            { assertThat(actual.quantity).isEqualTo(quantity) },
            { assertThat(actual.matchCount()).isEqualTo(rank.matchCount) },
            { assertThat(actual.reward()).isEqualTo(rank.reward) },
            { assertThat(actual.totalReward()).isEqualTo(rank.reward * quantity) },
        )
    }

    @Test
    fun `당첨 순위별 갯수가 음수로 생성될 경우 에러를 반환한다`() {
        assertAll(
            {
                assertDoesNotThrow {
                    LottoRecord(Rank.NONE_RANK, 0)
                }
            },
            {
                assertThrows<IllegalArgumentException> {
                    LottoRecord(Rank.NONE_RANK, -1)
                }
            },
        )
    }

    @ParameterizedTest
    @CsvSource(value = ["3:3", "10:10", "0:0"], delimiter = ':')
    fun `일치하는 당청등급을 1회 발견당 등급의 수량이 1씩 증가한다`(
        matchCount: Int,
        expectedQuantity: Int,
    ) {
        // Given
        val actual = LottoRecord(Rank.FIRST_RANK)

        // When
        actual.addQuantityByCount(matchCount)

        // Then
        assertThat(actual.quantity).isEqualTo(expectedQuantity)
    }

    companion object {

        @JvmStatic
        fun matchRankProvider() = listOf(
            Arguments.of(Rank.FIRST_RANK, 10),
            Arguments.of(Rank.SECOND_BONUS_RANK, 2),
            Arguments.of(Rank.SECOND_RANK, 3),
            Arguments.of(Rank.THIRD_RANK, 1),
            Arguments.of(Rank.FOURTH_RANK, 100),
            Arguments.of(Rank.NONE_RANK, 300),
        )
    }
}
