package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class LottoNumberTest {

    @ParameterizedTest
    @MethodSource("makeLottoNumber")
    fun `로또 번호가 1~45 사이에 중복없는 숫자 6개가 아닌 경우 IllegalArgumentException 을 발생`(lottoNumber: List<Int>) {
        shouldThrow<IllegalArgumentException> {
            LottoNumber(lottoNumber)
        }
    }

    @ParameterizedTest(name = "matches {2}")
    @MethodSource("makeWinLottoNumber")
    fun `로또 번호는 당첨 번호와 비교해서 몇등 당첨인지를 알 수 있다`(
        purchasedLottoNumber: LottoNumber,
        winLottoNumber: LottoNumber,
        expected: LottoRanking,
    ) {
        val actual = purchasedLottoNumber.getRanking(winLottoNumber)
        actual shouldBe expected
    }

    companion object {

        private val DEFAULT_LOTTO_NUMBER = LottoNumber((1..6).toList())

        @JvmStatic
        fun makeLottoNumber(): List<Arguments> = listOf(
            Arguments.of(listOf(0, 2, 3, 4, 5)),
            Arguments.of(listOf(1, 2, 3, 4, 46)),
            Arguments.of(listOf(111, 22, 33, 44, 45)),
        )

        @JvmStatic
        fun makeWinLottoNumber(): List<Arguments> = listOf(
            Arguments.of(LottoNumber(DEFAULT_LOTTO_NUMBER), LottoNumber((1..6).toList()), LottoRanking.ONE_ST),
            Arguments.of(LottoNumber(DEFAULT_LOTTO_NUMBER), LottoNumber((2..7).toList()), LottoRanking.TWO_ND),
            Arguments.of(LottoNumber(DEFAULT_LOTTO_NUMBER), LottoNumber((3..8).toList()), LottoRanking.THREE_RD),
            Arguments.of(LottoNumber(DEFAULT_LOTTO_NUMBER), LottoNumber((4..9).toList()), LottoRanking.FOUR_TH),
            Arguments.of(LottoNumber(DEFAULT_LOTTO_NUMBER), LottoNumber((5..10).toList()), LottoRanking.OUT_OF_RAKING),
            Arguments.of(LottoNumber(DEFAULT_LOTTO_NUMBER), LottoNumber((6..11).toList()), LottoRanking.OUT_OF_RAKING),
            Arguments.of(LottoNumber(DEFAULT_LOTTO_NUMBER), LottoNumber((7..12).toList()), LottoRanking.OUT_OF_RAKING),
        )
    }
}
