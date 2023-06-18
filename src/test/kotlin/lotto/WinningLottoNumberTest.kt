package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers
import lotto.domain.LottoRanking
import lotto.domain.WinningLottoNumber
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource

class WinningLottoNumberTest {

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
