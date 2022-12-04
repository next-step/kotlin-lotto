package lotto.domain.vo

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.should
import io.kotest.matchers.string.startWith

class PurchaseAmountTest : FunSpec({
    context("객체 생성") {
        test("자연수를 입력받아 객체를 생성한다.") {
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
})
