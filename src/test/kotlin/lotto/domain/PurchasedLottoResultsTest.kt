package lotto.domain

import io.kotest.assertions.throwables.shouldThrowWithMessage
import lotto.domain.PurchasedLottoResults.Companion.INVALID_LOTTO_MATCH_COUNT_MESSAGE
import lotto.domain.PurchasedLottoResults.Companion.INVALID_PURCHASED_COUNT_LOTTO_MATCH_COUNT_MESSAGE
import lotto.domain.PurchasedLottoTickets.Companion.INVALID_PURCHASED_COUNT_MESSAGE
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

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
}
