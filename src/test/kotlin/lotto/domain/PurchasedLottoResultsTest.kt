package lotto.domain

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.matchers.equals.shouldBeEqual
import lotto.domain.PurchasedLottoResults.Companion.INVALID_LOTTO_MATCH_COUNT_MESSAGE
import lotto.domain.PurchasedLottoResults.Companion.INVALID_PURCHASED_COUNT_LOTTO_MATCH_COUNT_MESSAGE
import lotto.domain.PurchasedLottoTickets.Companion.INVALID_PURCHASED_COUNT_MESSAGE
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PurchasedLottoResultsTest {
    @Test
    fun `로또 구매 개수가 1개 미만 일 경우 에러가 발생한다`() {
        shouldThrowWithMessage<IllegalArgumentException>(message = INVALID_PURCHASED_COUNT_MESSAGE) {
            PurchasedLottoResults(
                purchasedCount = 0,
                threeNumberMatchCount = 0,
                fourNumberMatchCount = 0,
                fiveNumberMatchCount = 0,
                sixNumberMatchCount = 0,
            )
        }
    }

    @ParameterizedTest
    @CsvSource(
        "-1, 2, 3, 6",
        "2, 3, -2, 1",
        "0, -1, 0, 0",
        "1, 2, 3, -1",
    )
    fun `로또 당첨 개수가 0개 미만 일 경우 에러가 발생한다`(
        threeNumberMatchCount: Int,
        fourNumberMatchCount: Int,
        fiveNumberMatchCount: Int,
        sixNumberMatchCount: Int,
    ) {
        shouldThrowWithMessage<IllegalArgumentException>(message = INVALID_LOTTO_MATCH_COUNT_MESSAGE) {
            PurchasedLottoResults(
                purchasedCount = 100,
                threeNumberMatchCount = threeNumberMatchCount,
                fourNumberMatchCount = fourNumberMatchCount,
                fiveNumberMatchCount = fiveNumberMatchCount,
                sixNumberMatchCount = sixNumberMatchCount,
            )
        }
    }

    @ParameterizedTest
    @CsvSource(
        "3, 1, 2, 3, 6",
        "20, 20, 3, 2, 1",
        "20, 20, 30, 2, 1",
        "40, 20, 30, 2, 1",
        "49, 10, 10, 20, 10",
    )
    fun `로또 당첨 개수의 합이 구매한 로또 개수보다 많을 경우 에러가 발생한다`(
        purchasedCount: Int,
        threeNumberMatchCount: Int,
        fourNumberMatchCount: Int,
        fiveNumberMatchCount: Int,
        sixNumberMatchCount: Int,
    ) {
        shouldThrowWithMessage<IllegalArgumentException>(message = INVALID_PURCHASED_COUNT_LOTTO_MATCH_COUNT_MESSAGE) {
            PurchasedLottoResults(
                purchasedCount = purchasedCount,
                threeNumberMatchCount = threeNumberMatchCount,
                fourNumberMatchCount = fourNumberMatchCount,
                fiveNumberMatchCount = fiveNumberMatchCount,
                sixNumberMatchCount = sixNumberMatchCount,
            )
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
        val purchasedLottoResults = purchasedLottoTickets.resultLottoPayout(lottoWinnerNumbers)

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
