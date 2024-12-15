package lotto.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class AmountTest : FreeSpec({
    "입력된 금액이 1천원 단위가 아니면 예외를 발생시킨다" - {
        listOf(999L, 1001L, 1010L, 1100L, 1111L)
            .forEach { amount ->
                "입력값: $amount" {
                    shouldThrow<InvalidAmountException> { LottoAmount(amount) }
                }
            }
    }

    "구매가 가능한 개수인지 판단한다" - {
        val lottoAmount = LottoAmount(1000)

        "구매가 가능한 경우 예외가 발생하지 않는다" {
            shouldNotThrowAny { lottoAmount.validatePurchasable(1) }
        }

        "구매가 불가능한 경우 예외가 발생한다" {
            shouldThrow<NotEnoughAmountException> { lottoAmount.validatePurchasable(2) }
        }
    }

    "현재 금액으로 구매가 가능한 개수를 반환한다" {
        val lottoAmount = LottoAmount(10000)

        lottoAmount.calculatePurchasableLottoCount() shouldBe 10
    }
})
