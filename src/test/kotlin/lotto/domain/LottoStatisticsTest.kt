package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LottoStatisticsTest {

    @Test
    fun getWinningStatistics() {
        val matchNumber = 5

        val winningLottoNumbers = "1,2,3,4,5,6"
        val winningLotto = LottoGenerator.generateLotto(winningLottoNumbers)
        val lottoStatistics = LottoStatistics(winningLotto)

        val numbers = "1, 2, 3, 4, 5, 7"
        val lottoCount: Long = 3
        val lottoList = (1..lottoCount).map {
            LottoGenerator.generateLotto(numbers)
        }

        val lottoMatchList = lottoStatistics.getWinningStatistics(lottoList)

        val lottoMatch = lottoMatchList.first { it.matchNumber == matchNumber }

        assertThat(lottoMatch.matchCount).isEqualTo(lottoCount)
        assertThat(lottoMatch.matchNumber).isEqualTo(matchNumber)
    }

    @Test
    fun getProfit() {
        val winningLotto = LottoGenerator.generateLotto("1,2,3,4,5,6")
        val lottoStatistics = LottoStatistics(winningLotto)

        val lottoMatchList = mutableListOf<LottoMatch>()
        val forthPlaceMatch = LottoMatch(
            matchNumber = 3,
            reward = 5000,
            matchCount = 1
        )
        lottoMatchList.add(forthPlaceMatch)

        val lottoCount = 14
        val totalPrice = lottoCount * LottoPurchase.LOTTO_PRICE

        val resultProfit = lottoStatistics.getProfit(totalPrice, lottoMatchList)

        assertThat(resultProfit).isEqualTo(0.35)
    }

    @ParameterizedTest
    @ValueSource(doubles = [1.0, 1.1, 2.2])
    fun `isProfitable should be ture when profit greater and equal than 1`(profit: Double) {
        val winningLotto = LottoGenerator.generateLotto("1,2,3,4,5,6")
        val lottoStatistics = LottoStatistics(winningLotto)
        val result = lottoStatistics.isProfitable(profit)

        assertThat(result).isTrue
    }

    @ParameterizedTest
    @ValueSource(doubles = [0.0, 0.2, 0.99])
    fun `isProfitable should be false when profit less than 1`(profit: Double) {
        val winningLotto = LottoGenerator.generateLotto("1,2,3,4,5,6")
        val lottoStatistics = LottoStatistics(winningLotto)
        val result = lottoStatistics.isProfitable(profit)

        assertThat(result).isFalse
    }
}
