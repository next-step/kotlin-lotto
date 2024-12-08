package lotto.domain

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.matchers.equals.shouldBeEqual
import lotto.domain.LottoNumber.Companion.INVALID_LOTTO_NUMBER_MESSAGE
import lotto.domain.LottoNumbers.Companion.INVALID_LOTTO_NUMBER_COUNT_MESSAGE
import lotto.domain.LottoWinnerNumbers.Companion.INVALID_WINNER_NUMBERS_MESSAGE
import lotto.util.createLottoNumbers
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LottoWinnerNumbersTest {
    @Test
    fun `로또 당첨 번호가 1부터 45사이의 숫자가 아닐 경우 에러가 발생한다`() {
        shouldThrowWithMessage<IllegalArgumentException>(message = INVALID_LOTTO_NUMBER_MESSAGE) {
            LottoWinnerNumbers(createLottoNumbers(1, 2, 3, 4, 5, 46), LottoNumber.of(7))
        }
    }

    @Test
    fun `로또 당첨 번호가 6개가 아닐 경우 에러가 발생한다`() {
        shouldThrowWithMessage<IllegalArgumentException>(message = INVALID_LOTTO_NUMBER_COUNT_MESSAGE) {
            LottoWinnerNumbers(createLottoNumbers(1, 2, 3, 4, 5, 6, 7), LottoNumber.of(8))
        }
    }

    @Test
    fun `당첨 번호와 보너스 번호가 중복되면 에러가 발생한다`() {
        shouldThrowWithMessage<IllegalArgumentException>(message = INVALID_WINNER_NUMBERS_MESSAGE) {
            LottoWinnerNumbers(createLottoNumbers(1, 2, 3, 4, 5, 6), LottoNumber.of(1))
        }
    }

    @MethodSource("구매한 로또의 번호 및 당첨 번호, 매칭 결과 및 수익률 제공")
    @ParameterizedTest
    fun `구매한 로또 번호가 당첨 번호와 몇개가 일치하는지와 수익률 등 결과 확인 (3개부터)`(
        purchasedCount: Int,
        lottoNumbers: Set<Int>,
        winnerNumbers: Set<Int>,
        bonusNumber: Int,
        firstRankCount: Int,
        secondRankCount: Int,
        thirdRankCount: Int,
        fourthRankCount: Int,
        fifthRankCount: Int,
        profitMargin: Double,
    ) {
        val purchasedLottoTickets =
            PurchasedLottoTickets(purchasedCount = purchasedCount, generateLottoNumbers = { lottoNumbers })

        val lottoWinnerNumbers =
            LottoWinnerNumbers(
                lottoNumbers = LottoNumbers(winnerNumbers.map { LottoNumber.of(it) }.toSet()),
                bonusNumber = LottoNumber.of(bonusNumber),
            )

        val purchasedLottoResults = lottoWinnerNumbers.resultLottoPayout(purchasedLottoTickets)

        purchasedLottoResults.firstRankCount shouldBeEqual firstRankCount
        purchasedLottoResults.secondRankCount shouldBeEqual secondRankCount
        purchasedLottoResults.thirdRankCount shouldBeEqual thirdRankCount
        purchasedLottoResults.fourthRankCount shouldBeEqual fourthRankCount
        purchasedLottoResults.fifthRankCount shouldBeEqual fifthRankCount
        purchasedLottoResults.getProfitMargin() shouldBeEqual profitMargin
    }

    fun `구매한 로또의 번호 및 당첨 번호, 매칭 결과 및 수익률 제공`(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(5, setOf(1, 2, 3, 4, 5, 6), setOf(11, 15, 16, 17, 18, 19), 3, 0, 0, 0, 0, 0, 0.0),
            Arguments.of(25, setOf(1, 2, 3, 4, 5, 6), setOf(4, 15, 16, 17, 18, 19), 7, 0, 0, 0, 0, 0, 0.0),
            Arguments.of(35, setOf(1, 2, 3, 4, 5, 6), setOf(4, 5, 16, 17, 18, 19), 20, 0, 0, 0, 0, 0, 0.0),
            Arguments.of(5, setOf(1, 2, 3, 4, 5, 6), setOf(4, 5, 6, 7, 8, 9), 21, 0, 0, 0, 0, 5, 5.0),
            Arguments.of(8, setOf(11, 12, 13, 14, 15, 16), setOf(13, 14, 15, 16, 17, 18), 22, 0, 0, 0, 8, 0, 50.0),
            Arguments.of(3, setOf(21, 22, 23, 24, 25, 26), setOf(21, 22, 23, 24, 25, 1), 2, 0, 0, 3, 0, 0, 1500.0),
            Arguments.of(3, setOf(21, 22, 23, 24, 25, 26), setOf(21, 22, 23, 24, 25, 1), 26, 0, 3, 0, 0, 0, 30000.0),
            Arguments.of(1, setOf(31, 32, 33, 34, 35, 41), setOf(31, 32, 33, 34, 35, 41), 9, 1, 0, 0, 0, 0, 2000000.0),
        )
    }
}
