package lotto.domain

import org.assertj.core.api.Assertions
import org.assertj.core.data.MapEntry
import org.junit.jupiter.api.Test

class WinnerTypeStatTest {
    val purchaseRecord = PurchaseRecord(
        listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }),
            Lotto(listOf(2, 3, 4, 5, 6, 7).map { LottoNumber(it) }),
            Lotto(listOf(3, 4, 5, 6, 7, 8).map { LottoNumber(it) }),
            Lotto(listOf(4, 5, 6, 7, 8, 9).map { LottoNumber(it) }),
            Lotto(listOf(5, 6, 7, 8, 9, 10).map { LottoNumber(it) }),
            Lotto(listOf(9, 10, 11, 12, 13, 14).map { LottoNumber(it) }),
        )
    )

    val winner = Winner(Lotto(listOf(3, 4, 5, 6, 7, 8).map { LottoNumber(it) }), LottoNumber(9))

    val stat = WinnerStat(purchaseRecord, winner)

    @Test
    fun `3~6개 일치 항목별 당첨 수를 갖는다`() {
        Assertions.assertThat(stat.winnerTypeMap.size).isEqualTo(4)
        Assertions.assertThat(stat.winnerTypeMap).containsOnly(
            MapEntry.entry(WinnerType.MATCHED_SIX_NUMBERS, 1),
            MapEntry.entry(WinnerType.MATCHED_FIVE_NUMBERS_WITH_BONUS, 1),
            MapEntry.entry(WinnerType.MATCHED_FIVE_NUMBERS, 1),
            MapEntry.entry(WinnerType.MATCHED_FOUR_NUMBERS, 2)
        )
    }

    @Test
    fun `총 수익률을 반환한다`() {
        Assertions.assertThat(stat.per()).isEqualTo(
            (
                WinnerType.MATCHED_SIX_NUMBERS.prizeMonery * 1 +
                    WinnerType.MATCHED_FIVE_NUMBERS_WITH_BONUS.prizeMonery * 1 +
                    WinnerType.MATCHED_FIVE_NUMBERS.prizeMonery * 1 +
                    WinnerType.MATCHED_FOUR_NUMBERS.prizeMonery * 2
                ) / (purchaseRecord.lottoList.size.toDouble() * 1000)
        )
    }
}
