package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.math.BigDecimal
import java.math.RoundingMode
import java.util.*
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class LottoTicketTest {

    @ParameterizedTest
    @MethodSource("getMissedRankLottoGamePackages")
    fun `2개의 로또 게임 중 당첨번호와 3개 이상 일치하는 게임번호가 없을 경우 결과통계에는 MISSED Rank만 존재하고 수익율은 0을 반환한다`(
        gameNumbers: List<List<Int>>
    ) {
        val purchaseAmount = LottoPurchaseAmount(2000)
        val lottoPurchaseInfo = LottoPurchaseInfo(LottoPurchaseCount.from(purchaseAmount), purchaseAmount)

        val gameNumberPackages = gameNumbers.map { it -> LottoNumberPackage(it.map { LottoNumber(it) }.toSet()) }.toList()
        val lottoTicket = LottoTicket(lottoPurchaseInfo, gameNumberPackages)

        val winningNumbers = listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }.toSet()
        val winningNumberPackage = LottoNumberPackage(winningNumbers)

        val winningInfo = WinningInfo(winningNumberPackage)
        val resultStatistics = lottoTicket.getResultStatistics(winningInfo)
        val expectedTotalProfitRate = BigDecimal(0.00).setScale(2, RoundingMode.HALF_UP)

        assertThat(resultStatistics).isNotNull
        assertThat(resultStatistics.getOrDefault(LottoResultRank.MISSED, 0)).isEqualTo(2)
        assertThat(lottoTicket.getTotalProfitRate(winningInfo)).isEqualTo(expectedTotalProfitRate)
    }

    private fun getMissedRankLottoGamePackages(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(
                listOf(
                    listOf(7, 8, 9, 10, 11, 12),
                    listOf(13, 14, 15, 16, 17, 18),
                )
            ),
            Arguments.of(
                listOf(
                    listOf(1, 8, 9, 10, 11, 12),
                    listOf(2, 14, 15, 16, 17, 18),
                )
            ),
            Arguments.of(
                listOf(
                    listOf(1, 2, 9, 10, 11, 12),
                    listOf(3, 4, 15, 16, 17, 18),
                )
            ),
        )
    }

    @ParameterizedTest
    @MethodSource("getOneFifthRankLottoGamePackages")
    fun `5개의 로또 게임 중 당첨번호와 3개가 일치하는 게임번호가 1개 있을 경우 결과통계와 수익율을 정상적으로 반환한다`(
        gameNumbers: List<List<Int>>
    ) {
        val purchaseAmount = LottoPurchaseAmount(5000)
        val lottoPurchaseInfo = LottoPurchaseInfo(LottoPurchaseCount.from(purchaseAmount), purchaseAmount)

        val gameNumberPackages = gameNumbers.map { it -> LottoNumberPackage(it.map { LottoNumber(it) }.toSet()) }.toList()
        val lottoTicket = LottoTicket(lottoPurchaseInfo, gameNumberPackages)

        val winningNumbers = listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }.toSet()
        val winningNumberPackage = LottoNumberPackage(winningNumbers)

        val winningInfo = WinningInfo(winningNumberPackage)
        val resultStatistics = lottoTicket.getResultStatistics(winningInfo)
        val expectedTotalProfitRate = BigDecimal(1.00).setScale(2, RoundingMode.HALF_UP)

        assertThat(resultStatistics).isNotNull
        assertThat(resultStatistics.getOrDefault(LottoResultRank.MISSED, 0)).isEqualTo(4)
        assertThat(resultStatistics.getOrDefault(LottoResultRank.FIFTH, 0)).isEqualTo(1)
        assertThat(lottoTicket.getTotalProfitRate(winningInfo)).isEqualTo(expectedTotalProfitRate)
    }

    private fun getOneFifthRankLottoGamePackages(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(
                listOf(
                    listOf(1, 2, 3, 10, 11, 12),
                    listOf(2, 14, 15, 16, 17, 18),
                    listOf(3, 19, 20, 21, 22, 23),
                    listOf(4, 24, 25, 26, 27, 28),
                    listOf(5, 29, 30, 31, 32, 33),
                )
            ),
            Arguments.of(
                listOf(
                    listOf(2, 3, 4, 10, 11, 12),
                    listOf(2, 3, 15, 16, 17, 18),
                    listOf(3, 4, 20, 21, 22, 23),
                    listOf(4, 5, 25, 26, 27, 28),
                    listOf(5, 6, 30, 31, 32, 33),
                )
            ),
            Arguments.of(
                listOf(
                    listOf(4, 5, 6, 10, 11, 12),
                    listOf(2, 3, 15, 16, 17, 18),
                    listOf(3, 4, 20, 21, 22, 23),
                    listOf(4, 5, 25, 26, 27, 28),
                    listOf(29, 30, 31, 32, 33, 34),
                )
            ),
        )
    }

    @ParameterizedTest
    @MethodSource("getFifthAndFourthRankLottoGamePackages")
    fun `5개의 로또 게임 중 당첨번호와 3개가 일치하는 게임번호가 1개 있고, 4개가 일치하는 게임번호가 1개 있을 경우 결과통계와 수익율을 정상적으로 반환한다`(
        gameNumbers: List<List<Int>>
    ) {
        val purchaseAmount = LottoPurchaseAmount(5000)
        val lottoPurchaseInfo = LottoPurchaseInfo(LottoPurchaseCount.from(purchaseAmount), purchaseAmount)

        val gameNumberPackages = gameNumbers.map { it -> LottoNumberPackage(it.map { LottoNumber(it) }.toSet()) }.toList()
        val lottoTicket = LottoTicket(lottoPurchaseInfo, gameNumberPackages)

        val winningNumbers = listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }.toSet()
        val winningNumberPackage = LottoNumberPackage(winningNumbers)

        val winningInfo = WinningInfo(winningNumberPackage)
        val resultStatistics = lottoTicket.getResultStatistics(winningInfo)
        val expectedTotalProfitRate = BigDecimal(11.00).setScale(2, RoundingMode.HALF_UP)

        assertThat(resultStatistics).isNotNull
        assertThat(resultStatistics.getOrDefault(LottoResultRank.MISSED, 0)).isEqualTo(3)
        assertThat(resultStatistics.getOrDefault(LottoResultRank.FIFTH, 0)).isEqualTo(1)
        assertThat(resultStatistics.getOrDefault(LottoResultRank.FOURTH, 0)).isEqualTo(1)
        assertThat(lottoTicket.getTotalProfitRate(winningInfo)).isEqualTo(expectedTotalProfitRate)
    }

    private fun getFifthAndFourthRankLottoGamePackages(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(
                listOf(
                    listOf(1, 2, 3, 4, 11, 12),
                    listOf(4, 5, 6, 16, 17, 18),
                    listOf(3, 19, 20, 21, 22, 23),
                    listOf(4, 24, 25, 26, 27, 28),
                    listOf(5, 29, 30, 31, 32, 33),
                )
            ),
            Arguments.of(
                listOf(
                    listOf(3, 4, 5, 6, 11, 12),
                    listOf(2, 3, 4, 16, 17, 18),
                    listOf(3, 4, 20, 21, 22, 23),
                    listOf(4, 5, 25, 26, 27, 28),
                    listOf(5, 6, 30, 31, 32, 33),
                )
            ),
            Arguments.of(
                listOf(
                    listOf(1, 4, 5, 6, 10, 11),
                    listOf(4, 5, 6, 16, 17, 18),
                    listOf(3, 4, 20, 21, 22, 23),
                    listOf(4, 5, 25, 26, 27, 28),
                    listOf(29, 30, 31, 32, 33, 34),
                )
            ),
        )
    }

    @ParameterizedTest
    @MethodSource("getThirdRankLottoGamePackages")
    fun `5개의 로또 게임 중 당첨번호와 5개가 일치하는 게임번호가 1개 있을 경우 결과통계와 수익율을 정상적으로 반환한다`(
        gameNumbers: List<List<Int>>
    ) {
        val purchaseAmount = LottoPurchaseAmount(5000)
        val lottoPurchaseInfo = LottoPurchaseInfo(LottoPurchaseCount.from(purchaseAmount), purchaseAmount)

        val gameNumberPackages = gameNumbers.map { it -> LottoNumberPackage(it.map { LottoNumber(it) }.toSet()) }.toList()
        val lottoTicket = LottoTicket(lottoPurchaseInfo, gameNumberPackages)

        val winningNumbers = listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }.toSet()
        val winningNumberPackage = LottoNumberPackage(winningNumbers)

        val winningInfo = WinningInfo(winningNumberPackage)
        val resultStatistics = lottoTicket.getResultStatistics(winningInfo)
        val expectedTotalProfitRate = BigDecimal(300.00).setScale(2, RoundingMode.HALF_UP)

        assertThat(resultStatistics).isNotNull
        assertThat(resultStatistics.getOrDefault(LottoResultRank.MISSED, 0)).isEqualTo(4)
        assertThat(resultStatistics.getOrDefault(LottoResultRank.THIRD, 0)).isEqualTo(1)
        assertThat(lottoTicket.getTotalProfitRate(winningInfo)).isEqualTo(expectedTotalProfitRate)
    }

    private fun getThirdRankLottoGamePackages(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(
                listOf(
                    listOf(1, 2, 3, 4, 5, 12),
                    listOf(1, 4, 15, 16, 17, 18),
                    listOf(3, 19, 20, 21, 22, 23),
                    listOf(4, 24, 25, 26, 27, 28),
                    listOf(5, 29, 30, 31, 32, 33),
                )
            ),
            Arguments.of(
                listOf(
                    listOf(2, 3, 4, 5, 6, 12),
                    listOf(2, 3, 15, 16, 17, 18),
                    listOf(3, 4, 20, 21, 22, 23),
                    listOf(4, 5, 25, 26, 27, 28),
                    listOf(5, 6, 30, 31, 32, 33),
                )
            ),
            Arguments.of(
                listOf(
                    listOf(1, 3, 4, 5, 6, 11),
                    listOf(4, 5, 15, 16, 17, 18),
                    listOf(3, 4, 20, 21, 22, 23),
                    listOf(4, 5, 25, 26, 27, 28),
                    listOf(29, 30, 31, 32, 33, 34),
                )
            ),
        )
    }

    @ParameterizedTest
    @MethodSource("getFirstRankLottoGamePackages")
    fun `5개의 로또 게임 중 당첨번호와 6개 일치하는 게임번호가 1개 있을 경우 결과통계와 수익율을 정상적으로 반환한다`(
        gameNumbers: List<List<Int>>
    ) {
        val purchaseAmount = LottoPurchaseAmount(5000)
        val lottoPurchaseInfo = LottoPurchaseInfo(LottoPurchaseCount.from(purchaseAmount), purchaseAmount)

        val gameNumberPackages = gameNumbers.map { it -> LottoNumberPackage(it.map { LottoNumber(it) }.toSet()) }.toList()
        val lottoTicket = LottoTicket(lottoPurchaseInfo, gameNumberPackages)

        val winningNumbers = listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }.toSet()
        val winningNumberPackage = LottoNumberPackage(winningNumbers)

        val winningInfo = WinningInfo(winningNumberPackage)
        val resultStatistics = lottoTicket.getResultStatistics(winningInfo)
        val expectedTotalProfitRate = BigDecimal(400000.00).setScale(2, RoundingMode.HALF_UP)

        assertThat(resultStatistics).isNotNull
        assertThat(resultStatistics.getOrDefault(LottoResultRank.MISSED, 0)).isEqualTo(4)
        assertThat(resultStatistics.getOrDefault(LottoResultRank.FIRST, 0)).isEqualTo(1)
        assertThat(lottoTicket.getTotalProfitRate(winningInfo)).isEqualTo(expectedTotalProfitRate)
    }

    private fun getFirstRankLottoGamePackages(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(
                listOf(
                    listOf(1, 2, 3, 4, 5, 6),
                    listOf(1, 4, 15, 16, 17, 18),
                    listOf(3, 19, 20, 21, 22, 23),
                    listOf(4, 24, 25, 26, 27, 28),
                    listOf(5, 29, 30, 31, 32, 33),
                )
            ),
            Arguments.of(
                listOf(
                    listOf(1, 2, 3, 4, 5, 6),
                    listOf(2, 3, 15, 16, 17, 18),
                    listOf(3, 4, 20, 21, 22, 23),
                    listOf(4, 5, 25, 26, 27, 28),
                    listOf(5, 6, 30, 31, 32, 33),
                )
            ),
            Arguments.of(
                listOf(
                    listOf(1, 2, 3, 4, 5, 6),
                    listOf(4, 5, 15, 16, 17, 18),
                    listOf(3, 4, 20, 21, 22, 23),
                    listOf(4, 5, 25, 26, 27, 28),
                    listOf(29, 30, 31, 32, 33, 34),
                )
            ),
        )
    }
}
