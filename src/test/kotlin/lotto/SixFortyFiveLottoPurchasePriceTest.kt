package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import lotto.sixFortyFiveNumberLotto.SixFortyFiveLottoPurchasePrice
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

class SixFortyFiveLottoPurchasePriceTest {

    @Test
    fun `로또의 최소 구입 금액은 1000원 입니다`() {
        val price = 1000

        val lottoPurchasePrice = SixFortyFiveLottoPurchasePrice(price)

        lottoPurchasePrice.value shouldBe price
    }

    @Test
    fun `로또의 최소 구입 금액 미만이면 오류를 반환합니다`() {
        val price = 900

        shouldThrow<IllegalArgumentException> { SixFortyFiveLottoPurchasePrice(price) }
            .message shouldBe (ErrorCode.INVALID_SIX_FORTY_FIVE_LOTTO_PURCHASE_PRICE.msg)
    }
}
