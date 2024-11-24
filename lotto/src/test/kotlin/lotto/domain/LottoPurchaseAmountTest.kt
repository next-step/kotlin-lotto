package lotto.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldContain
import org.junit.jupiter.api.Nested
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoPurchaseAmountTest {
    @Nested
    inner class ValidateTest {
        @ParameterizedTest
        @ValueSource(ints = [1000, 2000, 3000, 4000])
        fun `로또 1장의 최소 구매금액은 1000원이다`(purchaseAmount: Int) {
            val lottoPurchaseAmount = shouldNotThrowAny {
                LottoPurchaseAmount(purchaseAmount)
            }
            lottoPurchaseAmount.amount shouldBe purchaseAmount
        }

        @ParameterizedTest
        @ValueSource(ints = [200, 400, 600, 800, 999])
        fun `로또를 1000원 미만으로 구매하려는 경우 예외가 발생한다`(purchaseAmount: Int) {
            val exception = shouldThrowExactly<IllegalArgumentException> {
                LottoPurchaseAmount(purchaseAmount)
            }
            exception.message shouldContain "구매금액은 ${MIN_PURCHASE_AMOUNT}원 이상이어야 합니다"
        }

        @ParameterizedTest
        @ValueSource(ints = [1000, 2000, 3000, 4000])
        fun `로또 1장의 구매금액의 최소 단위는 1000원이다`(purchaseAmount: Int) {
            val lottoPurchaseAmount = shouldNotThrowAny {
                LottoPurchaseAmount(purchaseAmount)
            }
            lottoPurchaseAmount.amount shouldBe purchaseAmount
        }

        @ParameterizedTest
        @ValueSource(ints = [1001, 2010, 3100, 4111])
        fun `로또 1장의 구매금액이 1000원 단위가 아닌 경우 예외가 발생한다`(purchaseAmount: Int) {
            val exception = shouldThrowExactly<IllegalArgumentException> {
                LottoPurchaseAmount(purchaseAmount)
            }
            exception.message shouldContain "구매금액은 ${MIN_PURCHASE_AMOUNT}원 단위이어야 합니다"
        }
    }

    companion object {
        private const val MIN_PURCHASE_AMOUNT = 1000
    }
}
