package lotto.model

import lotto.model.LottoStatisticFormat.Companion.getRankCount
import lotto.model.LottoStatisticFormat.Companion.getRankProfit
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoStatisticTest {

    @Test
    @DisplayName("당첨 등수 개수 확인")
    fun `check each rank count`() {
        // given
        val resultList = hashMapOf(
            LottoRank.FIRST to 1,
            LottoRank.SECOND to 3,
            LottoRank.THIRD to 2,
            LottoRank.FOURTH to 4,
            LottoRank.FIFTH to 1
        )

        // when
        val firstRank = resultList.getRankCount(LottoRank.FIRST)
        val second = resultList.getRankCount(LottoRank.SECOND)
        val third = resultList.getRankCount(LottoRank.THIRD)
        val fourth = resultList.getRankCount(LottoRank.FOURTH)
        val fifth = resultList.getRankCount(LottoRank.FIFTH)

        // then
        Assertions.assertThat(firstRank).isEqualTo(1)
        Assertions.assertThat(second).isEqualTo(3)
        Assertions.assertThat(third).isEqualTo(2)
        Assertions.assertThat(fourth).isEqualTo(4)
        Assertions.assertThat(fifth).isEqualTo(1)
    }

    @Test
    @DisplayName("각 등수별 수익금 금액 확인")
    fun `check each rank profit price`() {
        // given
        val resultList = hashMapOf(
            LottoRank.FIRST to 1,
            LottoRank.SECOND to 3,
            LottoRank.THIRD to 2,
            LottoRank.FOURTH to 4,
            LottoRank.FIFTH to 1
        )

        // when
        val firstRank = resultList.getRankProfit(LottoRank.FIRST)
        val second = resultList.getRankProfit(LottoRank.SECOND)
        val third = resultList.getRankProfit(LottoRank.THIRD)
        val fourth = resultList.getRankProfit(LottoRank.FOURTH)
        val fifth = resultList.getRankProfit(LottoRank.FIFTH)

        // then
        Assertions.assertThat(firstRank).isEqualTo(1 * LottoRank.FIRST.winningMoney)
        Assertions.assertThat(second).isEqualTo(3 * LottoRank.SECOND.winningMoney)
        Assertions.assertThat(third).isEqualTo(2 * LottoRank.THIRD.winningMoney)
        Assertions.assertThat(fourth).isEqualTo(4 * LottoRank.FOURTH.winningMoney)
        Assertions.assertThat(fifth).isEqualTo(1 * LottoRank.FIFTH.winningMoney)
    }

    @Test
    @DisplayName("수익금 총 금액 확인")
    fun `check total profit price`() {
        // given
        val resultList = hashMapOf(
            LottoRank.FIRST to 1,
            LottoRank.SECOND to 0,
            LottoRank.THIRD to 0,
            LottoRank.FOURTH to 0,
            LottoRank.FIFTH to 0
        )
        val expectedTotalPrice = resultList.map { it.value * it.key.winningMoney }.sum()

        // when
        val totalPrice = LottoStatisticFormat.getTotalPrice(resultList)

        // then
        Assertions.assertThat(totalPrice).isEqualTo(expectedTotalPrice)
    }

    @Test
    @DisplayName("로또 당첨된 사람이 있는 경우의 수익률 계산")
    fun `check profit when is has winner`() {
        // given
        val price = Price(1000)
        val winList = hashMapOf(
            LottoRank.FIRST to 1,
            LottoRank.SECOND to 0,
            LottoRank.THIRD to 0,
            LottoRank.FOURTH to 0,
            LottoRank.FIFTH to 0
        )

        // when
        val statistic = LottoStatisticFormat(price, winList)
        val expectedProfit = ((LottoRank.FIRST.winningMoney * 1) / price.price).toDouble()

        // then
        Assertions.assertThat(statistic.profit)
            .isEqualTo(expectedProfit)
    }

    @Test
    @DisplayName("로또 당첨된 사람이 있는 경우의 수익률 계산")
    fun `check profit when it has none winner`() {
        // given
        val price = Price(1000)
        val winList = hashMapOf(
            LottoRank.FIRST to 0,
            LottoRank.SECOND to 0,
            LottoRank.THIRD to 0,
            LottoRank.FOURTH to 0,
            LottoRank.FIFTH to 0
        )

        // when
        val statistic = LottoStatisticFormat(price, winList)
        val expectedProfit = (0 / price.price).toDouble()

        // then
        Assertions.assertThat(statistic.profit)
            .isEqualTo(expectedProfit)
    }
}
