package lotto.domain

import lotto.util.ErrorCode
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LottoStatisticsTest {

    @ParameterizedTest
    @ValueSource(strings = ["1;2;3", "a,v,c"])
    fun `LottoStatistics init throw number format incorrect`(winningLottoNumbers: String) {
        val exception = assertThrows<IllegalArgumentException> {
            LottoStatistics(winningLottoNumbers)
        }

        assertThat(exception.message).isEqualTo(ErrorCode.LOTTO_NUMBERS_INPUT_FORMAT_EXCEPTION.errorMessage)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,4,5,6,7", "1,2,3,4,5", "1,1,1,1,1,1", ""])
    fun `LottoStatistics init throw numbers counts not 6`(winningLottoNumbers: String) {
        val exception = assertThrows<IllegalArgumentException> {
            LottoStatistics(winningLottoNumbers)
        }

        assertThat(exception.message).isEqualTo(ErrorCode.LOTTO_NUMBERS_COUNT_EXCEPTION.errorMessage)
    }

    @Test
    fun getWinningStatistics() {
        val matchNumber = 5

        val winningLottoNumbers = "1,2,3,4,5,6"
        val lottoStatistics = LottoStatistics(winningLottoNumbers)

        val numbers = listOf(1, 2, 3, 4, 5, 7)
        val lottoCount: Long = 3
        val lottoList = (1..lottoCount).map {
            Lotto(numbers)
        }

        val lottoMatchList = lottoStatistics.getWinningStatistics(lottoList)

        val lottoMatch = lottoMatchList.first { it.matchNumber == matchNumber }

        assertThat(lottoMatch.matchCount).isEqualTo(lottoCount)
        assertThat(lottoMatch.matchNumber).isEqualTo(matchNumber)
    }

    @Test
    fun getProfit() {
        val lottoStatistics = LottoStatistics("1,2,3,4,5,6")

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
        val lottoStatistics = LottoStatistics("1,2,3,4,5,6")
        val result = lottoStatistics.isProfitable(profit)

        assertThat(result).isTrue
    }

    @ParameterizedTest
    @ValueSource(doubles = [0.0, 0.2, 0.99])
    fun `isProfitable should be false when profit less than 1`(profit: Double) {
        val lottoStatistics = LottoStatistics("1,2,3,4,5,6")
        val result = lottoStatistics.isProfitable(profit)

        assertThat(result).isFalse
    }
}
