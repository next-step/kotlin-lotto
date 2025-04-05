package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class WinningStatisticsTest {
    @Test
    fun `Return profit rate 50 when cost is 1000 and rank is third`() {
        // given
        val lotto = listOf(Lotto((3..8).map { LottoNumber.of(it) }))
        val bonusNumber = LottoNumber.of(7)
        val winningLotto = WinningLotto(Lotto((1..6).map { LottoNumber.of(it) }), bonusNumber)

        val winningStatistics = WinningStatistics(lotto, winningLotto)
        val cost = 1000.0
        val expected = 50.0

        // when
        val actual = winningStatistics.calculateProfit(cost)

        // then
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `Return the count by rank`() {
        // given
        val lotto =
            listOf(
                Lotto((1..6).map { LottoNumber.of(it) }),
                Lotto((2..7).map { LottoNumber.of(it) }),
                Lotto((2..7).map { LottoNumber.of(it) }),
                Lotto((3..8).map { LottoNumber.of(it) }),
                Lotto((3..8).map { LottoNumber.of(it) }),
                Lotto((3..8).map { LottoNumber.of(it) }),
            )
        val bonusNumber = LottoNumber.of(7)
        val winningLotto = WinningLotto(Lotto((1..6).map { LottoNumber.of(it) }), bonusNumber)

        val winningStatistics = WinningStatistics(lotto, winningLotto)

        // when && then
        assertAll(
            { assertThat(winningStatistics.countBy(Rank.FIRST)).isEqualTo(1) },
            { assertThat(winningStatistics.countBy(Rank.SECOND)).isEqualTo(2) },
            { assertThat(winningStatistics.countBy(Rank.FOURTH)).isEqualTo(3) },
        )
    }
}
