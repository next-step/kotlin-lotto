package lotto.domain

import lotto.util.ErrorCode
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class WinningLottoStatisticsTest {

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5, 6])
    fun `init throw exception when winningLotto does not include bonusLottoNumber`(number: Int) {
        val previousWinningLottoNumbers = "1,2,3,4,5,6"
        val previousWinningLotto = LottoCustomGenerator.generateLotto(previousWinningLottoNumbers)
        val bonusLottoNumber = LottoNumber(number)

        val exception = assertThrows<IllegalArgumentException> {
            WinningLottoStatistics(previousWinningLotto = previousWinningLotto, bonusLottoNumber = bonusLottoNumber)
        }

        assertThat(exception.message).isEqualTo(ErrorCode.BONUS_LOTTO_NUMBER_EXCEPTION.errorMessage)
    }

    @Test
    fun getWinningStatistics() {
        val matchNumber = 5

        val winningLottoNumbers = "1,2,3,4,5,6"
        val previousWinningLotto = LottoCustomGenerator.generateLotto(winningLottoNumbers)
        val bonusLottoNumber = LottoNumber(7)
        val winningLottoStatistics = WinningLottoStatistics(previousWinningLotto, bonusLottoNumber)

        val numbers = "1, 2, 3, 4, 5, 7"
        val lottoCount = 3L
        val lottoList = (1..lottoCount).map {
            LottoCustomGenerator.generateLotto(numbers)
        }

        val list = LottoList(lottoList)

        val lottoMatchList = winningLottoStatistics.getWinningStatistics(list)

        // 2등
        val lottoMatch = lottoMatchList.first { it.lottoRank == LottoRank.SECOND_PLACE }

        assertThat(lottoMatch.matchTotalCount).isEqualTo(lottoCount)
        assertThat(lottoMatch.lottoRank.matchCount).isEqualTo(matchNumber)
    }

    @Test
    fun getProfit() {
        val previousWinningLotto = LottoCustomGenerator.generateLotto("1,2,3,4,5,6")
        val bonusLottoNumber = LottoNumber(7)
        val winningLottoStatistics = WinningLottoStatistics(previousWinningLotto, bonusLottoNumber)

        val lottoMatchList = mutableListOf<LottoMatch>()
        val forthPlaceMatch = LottoMatch(
            lottoRank = LottoRank.FIFTH_PLACE,
            matchTotalCount = 1
        )
        lottoMatchList.add(forthPlaceMatch)

        val lottoCount = 14
        val totalPrice = lottoCount * LottoPurchase.LOTTO_PRICE

        val resultProfit = winningLottoStatistics.getProfit(totalPrice, lottoMatchList)

        assertThat(resultProfit).isEqualTo(0.35)
    }

    @ParameterizedTest
    @ValueSource(doubles = [1.0, 1.1, 2.2])
    fun `isProfitable should be ture when profit greater and equal than 1`(profit: Double) {
        val previousWinningLotto = LottoCustomGenerator.generateLotto("1,2,3,4,5,6")
        val bonusLottoNumber = LottoNumber(7)
        val winningLottoStatistics = WinningLottoStatistics(previousWinningLotto, bonusLottoNumber)

        val result = winningLottoStatistics.isProfitable(profit)

        assertThat(result).isTrue
    }

    @ParameterizedTest
    @ValueSource(doubles = [0.0, 0.2, 0.99])
    fun `isProfitable should be false when profit less than 1`(profit: Double) {
        val previousWinningLotto = LottoCustomGenerator.generateLotto("1,2,3,4,5,6")
        val bonusLottoNumber = LottoNumber(7)
        val winningLottoStatistics = WinningLottoStatistics(previousWinningLotto, bonusLottoNumber)

        val result = winningLottoStatistics.isProfitable(profit)

        assertThat(result).isFalse
    }
}
