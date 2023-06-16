package lotto

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.math.BigDecimal

class WinningLottoNumberTest {

    @Test
    fun `로또 번호들을 지난 주 당첨번호와 비교해서 각 등수별 개수를 알 수 있다`() {
        val lottoNumbers = LottoNumbers(
            listOf(
                LottoNumber(listOf(1, 2, 3, 4, 5, 6)),
                LottoNumber(listOf(1, 2, 3, 4, 5, 45)),
                LottoNumber(listOf(1, 2, 3, 4, 5, 7)),
                LottoNumber(listOf(1, 2, 3, 4, 7, 8)),
                LottoNumber(listOf(1, 2, 3, 7, 8, 9)),
                LottoNumber(listOf(1, 2, 7, 8, 9, 10)),
            ),
        )
        val winLottoNumber = WinningLottoNumber(LottoNumber((1..6).toList()), 45)

        val result = winLottoNumber.makeRankingCountMap(lottoNumbers)

        result[LottoRanking.FIRST] shouldBe 1
        result[LottoRanking.SECOND] shouldBe 1
        result[LottoRanking.THIRD] shouldBe 1
        result[LottoRanking.FOURTH] shouldBe 1
        result[LottoRanking.FIFTH] shouldBe 1
        result[LottoRanking.MISS] shouldBe 1
    }

    @Test
    fun `로또 번호들을 지난 주 당첨번호와 비교해서 총 수익률을 계산할 수 있다`() {
        val lottoNumbers = LottoNumbers((1..14).map { LottoNumber((it..it + 5).toList()) })
        val winLottoNumber = WinningLottoNumber(LottoNumber(listOf(17, 18, 19, 20, 21, 22)), 1)

        val result = winLottoNumber.getRevenueRate(lottoNumbers)

        result shouldBe BigDecimal("0.35")
    }

    @ParameterizedTest(name = "matches {2}")
    @MethodSource("makeWinLottoNumber")
    fun `로또 번호는 당첨 번호와 비교해서 몇등 당첨인지를 알 수 있다`(
        purchasedLottoNumber: LottoNumber,
        winningLottoNumber: WinningLottoNumber,
        expected: LottoRanking,
    ) {
        val actual = winningLottoNumber.getRanking(purchasedLottoNumber)
        actual shouldBe expected
    }

    companion object {

        private val DEFAULT_LOTTO_NUMBER = LottoNumber((1..6).toList())

        @JvmStatic
        fun makeWinLottoNumber(): List<Arguments> = listOf(
            Arguments.of(
                LottoNumber(DEFAULT_LOTTO_NUMBER),
                WinningLottoNumber(winningNumber = LottoNumber((1..6).toList()), bonusBallNumber = 7),
                LottoRanking.FIRST,
            ),
            Arguments.of(
                LottoNumber(DEFAULT_LOTTO_NUMBER),
                WinningLottoNumber(winningNumber = LottoNumber((2..7).toList()), bonusBallNumber = 1),
                LottoRanking.SECOND,
            ),
            Arguments.of(
                LottoNumber(DEFAULT_LOTTO_NUMBER),
                WinningLottoNumber(winningNumber = LottoNumber((2..7).toList()), bonusBallNumber = 45),
                LottoRanking.THIRD,
            ),
            Arguments.of(
                LottoNumber(DEFAULT_LOTTO_NUMBER),
                WinningLottoNumber(winningNumber = LottoNumber((3..8).toList()), bonusBallNumber = 45),
                LottoRanking.FOURTH,
            ),
            Arguments.of(
                LottoNumber(DEFAULT_LOTTO_NUMBER),
                WinningLottoNumber(winningNumber = LottoNumber((4..9).toList()), bonusBallNumber = 45),
                LottoRanking.FIFTH,
            ),
            Arguments.of(
                LottoNumber(DEFAULT_LOTTO_NUMBER),
                WinningLottoNumber(winningNumber = LottoNumber((5..10).toList()), bonusBallNumber = 45),
                LottoRanking.MISS,
            ),
            Arguments.of(
                LottoNumber(DEFAULT_LOTTO_NUMBER),
                WinningLottoNumber(winningNumber = LottoNumber((6..11).toList()), bonusBallNumber = 45),
                LottoRanking.MISS,
            ),
        )
    }
}
