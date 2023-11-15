package lotto.domain

import lotto.enums.Rank
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoRecordsTest {

    @Test
    fun `당첨등급을 기준으로 당첨통계의 일급콜랙션을 생성한다`() {
        val actual = LottoRecords.fromRank()

        val lottoRecords = mutableSetOf<LottoRecord>()
        Rank.values().forEach {
            lottoRecords.add(LottoRecord(it))
        }

        assertThat(actual).usingRecursiveComparison()
            .isEqualTo(LottoRecords(lottoRecords))
    }

    @Test
    fun `랭크들을 받아서 랭크별 수량을 집계한다`() {
        // Given
        val givenRanks = listOf(
            Rank.NONE_RANK, Rank.NONE_RANK, Rank.NONE_RANK,
            Rank.FIRST_RANK,
            Rank.SECOND_BONUS_RANK, Rank.SECOND_BONUS_RANK,
            Rank.SECOND_RANK
        )
        val lottoRecords = LottoRecords.fromRank()

        // When
        val actual = lottoRecords.calculateRecords(givenRanks)

        // Then
        val expected = setOf(
            LottoRecord(Rank.FOURTH_RANK, 0),
            LottoRecord(Rank.THIRD_RANK, 0),
            LottoRecord(Rank.SECOND_RANK, 1),
            LottoRecord(Rank.SECOND_BONUS_RANK, 2),
            LottoRecord(Rank.FIRST_RANK, 1),
            LottoRecord(Rank.NONE_RANK, 3),
        )

        assertThat(actual).usingRecursiveComparison()
            .isEqualTo(expected)
    }

    @Test
    fun `총수익률을 반환한다`() {
        val givenRecords = setOf(
            LottoRecord(Rank.FOURTH_RANK, 1),
            LottoRecord(Rank.THIRD_RANK, 0),
            LottoRecord(Rank.SECOND_RANK, 0),
            LottoRecord(Rank.SECOND_BONUS_RANK, 0),
            LottoRecord(Rank.FIRST_RANK, 0),
            LottoRecord(Rank.NONE_RANK, 0),
        )
        val lottoRecords = LottoRecords(givenRecords)

        // When
        val actual = lottoRecords.calculateRateOfReturn(14000)

        // Then
        assertThat(actual).isEqualTo(0.35)
    }
}
