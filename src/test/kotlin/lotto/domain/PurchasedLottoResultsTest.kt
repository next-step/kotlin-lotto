package lotto.domain

import io.kotest.assertions.throwables.shouldThrowWithMessage
import lotto.domain.PurchasedLottoResults.Companion.INVALID_LOTTO_MATCH_COUNT_MESSAGE
import lotto.domain.PurchasedLottoResults.Companion.INVALID_PURCHASED_COUNT_LOTTO_MATCH_COUNT_MESSAGE
import lotto.domain.PurchasedLottoTickets.Companion.INVALID_PURCHASED_COUNT_MESSAGE
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PurchasedLottoResultsTest {
    @Test
    fun `로또 구매 개수가 1개 미만 일 경우 에러가 발생한다`() {
        shouldThrowWithMessage<IllegalArgumentException>(message = INVALID_PURCHASED_COUNT_MESSAGE) {
            PurchasedLottoResults(
                purchasedCount = 0,
                firstRankCount = 0,
                secondRankCount = 0,
                thirdRankCount = 0,
                fourthRankCount = 0,
                fifthRankCount = 0,
            )
        }
    }

    @ParameterizedTest
    @CsvSource(
        "-1, 2, 3, 6, 1",
        "2, 3, -2, 1, 3",
        "0, -1, 0, 0, 4",
        "1, 2, 3, -1, 5",
        "1, 2, 3, 1, -5",
    )
    fun `로또 당첨 개수가 0개 미만 일 경우 에러가 발생한다`(
        firstRankCount: Int,
        secondRankCount: Int,
        thirdRankCount: Int,
        fourthRankCount: Int,
        fifthRankCount: Int,
    ) {
        shouldThrowWithMessage<IllegalArgumentException>(message = INVALID_LOTTO_MATCH_COUNT_MESSAGE) {
            PurchasedLottoResults(
                purchasedCount = 100,
                firstRankCount = firstRankCount,
                secondRankCount = secondRankCount,
                thirdRankCount = thirdRankCount,
                fourthRankCount = fourthRankCount,
                fifthRankCount = fifthRankCount,
            )
        }
    }

    @ParameterizedTest
    @CsvSource(
        "3, 1, 2, 3, 6, 4",
        "20, 20, 3, 2, 1, 2",
        "20, 20, 30, 2, 1, 3",
        "40, 20, 30, 2, 1, 4",
        "49, 10, 10, 20, 10, 9",
    )
    fun `로또 당첨 개수의 합이 구매한 로또 개수보다 많을 경우 에러가 발생한다`(
        purchasedCount: Int,
        firstRankCount: Int,
        secondRankCount: Int,
        thirdRankCount: Int,
        fourthRankCount: Int,
        fifthRankCount: Int,
    ) {
        shouldThrowWithMessage<IllegalArgumentException>(message = INVALID_PURCHASED_COUNT_LOTTO_MATCH_COUNT_MESSAGE) {
            PurchasedLottoResults(
                purchasedCount = purchasedCount,
                firstRankCount = firstRankCount,
                secondRankCount = secondRankCount,
                thirdRankCount = thirdRankCount,
                fourthRankCount = fourthRankCount,
                fifthRankCount = fifthRankCount,
            )
        }
    }
}
