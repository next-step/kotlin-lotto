package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class WinningLottoStatisticsTest {

    lateinit var winningLotto: WinningLotto

    @BeforeEach
    fun setUp() {
        val previousWinningLotto =
            listOf(1, 2, 3, 4, 5, 6)
                .map { LottoNumber(it) }.toMutableSet()
                .let { Lotto(it) }

        val bonusLottoNumber = LottoNumber(7)
        winningLotto = WinningLotto(previousWinningLotto, bonusLottoNumber)
    }

    @Test
    fun getWinningStatistics() {
        val winningLottoStatistics = WinningLottoStatistics(winningLotto = winningLotto)

        val lottoNumbers = listOf(1, 2, 3, 4, 5, 7).map { LottoNumber(it) }.toMutableSet()
        val lottoCount = 3L
        val lottoList = (1..lottoCount).map {
            Lotto(lottoNumbers)
        }
        val list = LottoList(lottoList)

        val lottoMatchList = winningLottoStatistics.getWinningStatistics(list)

        // 2등
        lottoMatchList.lottoMatchList
            .filter { it.lottoRank == LottoRank.SECOND_PLACE }
            .forEach { lottoMatch ->
                assertAll(
                    "lottoMatch",
                    { assertThat(lottoMatch.matchTotalCount).isEqualTo(lottoCount) },
                    { assertThat(lottoMatch.lottoRank.matchCount).isEqualTo(5) }
                )
            }
    }

    @Test
    fun getProfit() {
        val winningLottoStatistics = WinningLottoStatistics(winningLotto)

        val lottoMatchList = mutableListOf<LottoMatch>()
        val forthPlaceMatch = LottoMatch(
            lottoRank = LottoRank.FIFTH_PLACE,
            matchTotalCount = 1
        )
        lottoMatchList.add(forthPlaceMatch)

        val lottoCount = 14
        val totalPrice = lottoCount * LottoPurchase.LOTTO_PRICE

        val resultProfit = winningLottoStatistics.getProfit(totalPrice, LottoMatchList(lottoMatchList))

        assertThat(resultProfit).isEqualTo(0.35)
    }

    @ParameterizedTest
    @ValueSource(doubles = [1.0, 1.1, 2.2])
    fun `isProfitable should be ture when profit greater and equal than 1`(profit: Double) {
        val winningLottoStatistics = WinningLottoStatistics(winningLotto)

        val result = winningLottoStatistics.isProfitable(profit)

        assertThat(result).isTrue
    }

    @ParameterizedTest
    @ValueSource(doubles = [0.0, 0.2, 0.99])
    fun `isProfitable should be false when profit less than 1`(profit: Double) {
        val winningLottoStatistics = WinningLottoStatistics(winningLotto = winningLotto)

        val result = winningLottoStatistics.isProfitable(profit)

        assertThat(result).isFalse
    }
}
