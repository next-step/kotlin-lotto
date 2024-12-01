package lotto.domain

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.matchers.equals.shouldBeEqual
import lotto.domain.LottoTicket.Companion.INVALID_WINNER_NUMBERS_RANGE_MESSAGE
import lotto.domain.LottoWinnerNumbers.Companion.INVALID_WINNER_NUMBERS_COUNT_MESSAGE
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
        shouldThrowWithMessage<IllegalArgumentException>(message = INVALID_WINNER_NUMBERS_RANGE_MESSAGE) {
            LottoWinnerNumbers(setOf(1,2,3,4,5,46))
        }
    }

    @Test
    fun `로또 당첨 번호가 6개가 아닐 경우 에러가 발생한다`() {
        shouldThrowWithMessage<IllegalArgumentException>(message = INVALID_WINNER_NUMBERS_COUNT_MESSAGE) {
            LottoWinnerNumbers(setOf(1,2,3,4,5,6,7))
        }
    }

    @MethodSource("구매한 로또의 번호 및 당첨 번호, 매칭 결과 및 수익률 제공")
    @ParameterizedTest
    fun `구매한 로또 번호가 당첨 번호와 몇개가 일치하는지와 수익률 등 결과 확인 (3개부터)`(
        purchasedCount: Int,
        lottoNumbers: Set<Int>,
        winnerNumbers: Set<Int>,
        threeNumberMatchCount: Int,
        fourNumberMatchCount: Int,
        fiveNumberMatchCount: Int,
        sixNumberMatchCount: Int,
        profitMargin: Double,
    ) {
        val purchasedLottoTickets =
            PurchasedLottoTickets(purchasedCount = purchasedCount, generateLottoNumbers = { lottoNumbers })
        val lottoWinnerNumbers = LottoWinnerNumbers(winnerNumbers = winnerNumbers)
        val purchasedLottoResults = lottoWinnerNumbers.resultLottoPayout(purchasedLottoTickets)

        purchasedLottoResults.threeNumberMatchCount shouldBeEqual threeNumberMatchCount
        purchasedLottoResults.fourNumberMatchCount shouldBeEqual fourNumberMatchCount
        purchasedLottoResults.fiveNumberMatchCount shouldBeEqual fiveNumberMatchCount
        purchasedLottoResults.sixNumberMatchCount shouldBeEqual sixNumberMatchCount
        purchasedLottoResults.getProfitMargin() shouldBeEqual profitMargin
    }

    fun `구매한 로또의 번호 및 당첨 번호, 매칭 결과 및 수익률 제공`(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(5, setOf(1, 2, 3, 4, 5, 6), setOf(11, 15, 16, 17, 18, 19), 0, 0, 0, 0, 0.0),
            Arguments.of(25, setOf(1, 2, 3, 4, 5, 6), setOf(4, 15, 16, 17, 18, 19), 0, 0, 0, 0, 0.0),
            Arguments.of(35, setOf(1, 2, 3, 4, 5, 6), setOf(4, 5, 16, 17, 18, 19), 0, 0, 0, 0, 0.0),
            Arguments.of(5, setOf(1, 2, 3, 4, 5, 6), setOf(4, 5, 6, 7, 8, 9), 5, 0, 0, 0, 5.0),
            Arguments.of(8, setOf(11, 12, 13, 14, 15, 16), setOf(13, 14, 15, 16, 17, 18), 0, 8, 0, 0, 50.0),
            Arguments.of(3, setOf(21, 22, 23, 24, 25, 26), setOf(21, 22, 23, 24, 25, 1), 0, 0, 3, 0, 1500.0),
            Arguments.of(1, setOf(31, 32, 33, 34, 35, 41), setOf(31, 32, 33, 34, 35, 41), 0, 0, 0, 1, 2000000.0),
        )
    }
}
