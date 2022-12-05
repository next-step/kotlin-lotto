package lotto.domain.vo

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.startWith

class PurchaseAmountTest : FunSpec({
    context("객체 생성") {
        test("1000의 배수를 입력받아 객체를 생성한다.") {
            shouldNotThrowAny {
                PurchaseAmount(1000)
            }
        }

        test("1000원 미만일 경우 예외가 발생한다.") {
            val actual = shouldThrow<IllegalArgumentException> {
                PurchaseAmount(999)
            }

            actual.message should startWith("amount should be at least ")
        }

        test("1000원 단위가 아닐 경우 예외가 발생한다.") {
            val actual = shouldThrow<IllegalArgumentException> {
                PurchaseAmount(1001)
            }

            actual.message should startWith("amount should be in units of")
        }
    }
    context("div()") {
        test("인자로 받은 숫자로 나눈 결과를 반환한다.") {
            val purchaseAmount = PurchaseAmount(1000)

            val actual = purchaseAmount.div(10)

            actual shouldBe 100
        }
    }
})
