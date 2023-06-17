package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import lotto.domain.LotteryTickets
import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers
import lotto.domain.LottoRanking
import lotto.domain.WinningLottoNumber
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import java.math.BigDecimal

class WinningLottoNumberTest {

    @Test
    fun `로또 번호들을 지난 주 당첨번호와 비교해서 각 등수별 개수를 알 수 있다`() {
        val lotteryTickets = LotteryTickets(
            listOf(
                LottoTestHelper.makeLotteryTicket(listOf(1, 2, 3, 4, 5, 6)),
                LottoTestHelper.makeLotteryTicket(listOf(1, 2, 3, 4, 5, 45)),
                LottoTestHelper.makeLotteryTicket(listOf(1, 2, 3, 4, 5, 7)),
                LottoTestHelper.makeLotteryTicket(listOf(1, 2, 3, 4, 7, 8)),
                LottoTestHelper.makeLotteryTicket(listOf(1, 2, 3, 7, 8, 9)),
                LottoTestHelper.makeLotteryTicket(listOf(1, 2, 7, 8, 9, 10)),
            ),
        )
        val winLottoNumber = LottoTestHelper.makeWinningLottoNumbers((1..6).toList(), 45)

        val result = winLottoNumber.makeRankingCountMap(lotteryTickets)

        result[LottoRanking.FIRST] shouldBe 1
        result[LottoRanking.SECOND] shouldBe 1
        result[LottoRanking.THIRD] shouldBe 1
        result[LottoRanking.FOURTH] shouldBe 1
        result[LottoRanking.FIFTH] shouldBe 1
        result[LottoRanking.MISS] shouldBe 1
    }

    @Test
    fun `로또 번호들을 지난 주 당첨번호와 비교해서 총 수익률을 계산할 수 있다`() {
        val lotteryTickets = LotteryTickets(
            (1..14).map {
                LottoTestHelper.makeLotteryTicket((it..it + 5).toList())
            },
        )
        val winLottoNumber = LottoTestHelper.makeWinningLottoNumbers(
            numbers = listOf(17, 18, 19, 20, 21, 22),
            bonusNumber = 1,
        )

        val result = winLottoNumber.getRevenueRate(lotteryTickets)

        result shouldBe BigDecimal("0.35")
    }

    @ParameterizedTest(name = "matches {2}")
    @MethodSource("makeWinLottoNumber")
    fun `로또 번호는 당첨 번호와 비교해서 몇등 당첨인지를 알 수 있다`(
        purchasedLottoNumber: LottoNumbers,
        winningLottoNumber: WinningLottoNumber,
        expected: LottoRanking,
    ) {
        val actual = winningLottoNumber.getRanking(purchasedLottoNumber)
        actual shouldBe expected
    }

    @ParameterizedTest
    @CsvSource("-1", "0", "46")
    fun `당첨 번호에 보너스 번호가 1~45 중에 포함되지 않을 경우 IllegalArgumentException 을 발생시킨다`(bonusBallNumber: Int) {
        val lottoNumber = LottoTestHelper.makeLottoNumbers(listOf(1, 2, 3, 4, 5, 6))
        shouldThrow<IllegalArgumentException> {
            WinningLottoNumber(winningNumbers = lottoNumber, bonusLottoNumber = LottoNumber(bonusBallNumber))
        }
    }

    @Test
    fun `보너스 번호가 당첨번호에 존재하는 경우 IllegalArgumentException 을 발생시킨다`() {
        val lottoNumbers = LottoTestHelper.makeLottoNumbers(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = LottoNumber(6)

        shouldThrow<IllegalArgumentException> {
            WinningLottoNumber(winningNumbers = lottoNumbers, bonusLottoNumber = bonusNumber)
        }
    }

    companion object {

        private val DEFAULT_LOTTO_NUMBER = LottoTestHelper.makeLottoNumbers((1..6).toList())

        @JvmStatic
        fun makeWinLottoNumber(): List<Arguments> = listOf(
            Arguments.of(
                DEFAULT_LOTTO_NUMBER,
                LottoTestHelper.makeWinningLottoNumbers((1..6).toList(), 7),
                LottoRanking.FIRST,
            ),
            Arguments.of(
                DEFAULT_LOTTO_NUMBER,
                LottoTestHelper.makeWinningLottoNumbers((2..7).toList(), 1),
                LottoRanking.SECOND,
            ),
            Arguments.of(
                DEFAULT_LOTTO_NUMBER,
                LottoTestHelper.makeWinningLottoNumbers((2..7).toList(), 45),
                LottoRanking.THIRD,
            ),
            Arguments.of(
                DEFAULT_LOTTO_NUMBER,
                LottoTestHelper.makeWinningLottoNumbers((3..8).toList(), 45),
                LottoRanking.FOURTH,
            ),
            Arguments.of(
                DEFAULT_LOTTO_NUMBER,
                LottoTestHelper.makeWinningLottoNumbers((4..9).toList(), 45),
                LottoRanking.FIFTH,
            ),
            Arguments.of(
                DEFAULT_LOTTO_NUMBER,
                LottoTestHelper.makeWinningLottoNumbers((5..10).toList(), 45),
                LottoRanking.MISS,
            ),
            Arguments.of(
                DEFAULT_LOTTO_NUMBER,
                LottoTestHelper.makeWinningLottoNumbers((6..11).toList(), 45),
                LottoRanking.MISS,
            ),
        )
    }
}
