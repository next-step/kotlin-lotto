package lotto.domain

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.matchers.equals.shouldBeEqual
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoPurchaseCalculatorTest {
    @ParameterizedTest
    @CsvSource(
        "1000, 1",
        "11000, 11",
        "5000, 5",
    )
    fun `로또 구입 비용을 토대로 최대 몇장의 로또를 구입할 수 있는지 계산할 수 있다`(
        amountPaid: Int,
        purchasedLottoTicketCount: Int,
    ) {
        LottoPurchaseCalculator.getMaxPurchasedLottoTicketCount(amountPaid) shouldBeEqual purchasedLottoTicketCount
    }

    @Test
    fun `최소한의 로또 구입 비용을 지불하지 않으면 에러가 발생한다`() {
        shouldThrowWithMessage<IllegalArgumentException>(message = "로또 구입 비용은 최소 1,000원 이상 이어야 합니다") {
            LottoPurchaseCalculator.getMaxPurchasedLottoTicketCount(999)
        }
    }

    @Test
    fun `로또 구입 비용이 1,000원 단위가 아닐 시 에러가 발생한다`() {
        shouldThrowWithMessage<IllegalArgumentException>(message = "로또 구입 비용은 1,000원 단위로 지불해야 합니다") {
            LottoPurchaseCalculator.getMaxPurchasedLottoTicketCount(1500)
        }
    }
}
