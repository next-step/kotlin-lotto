package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.should
import io.kotest.matchers.string.startWith
import java.lang.IllegalArgumentException

internal class PurchaseAmountTest: BehaviorSpec({
    given("구입 금액이") {
        `when`("숫자로 변환될 수 없는 문자가 입력되면"){
            val input = "24DFseff~345"

            then("IllegalArgumentException 을 반환한다."){
                val exception = shouldThrow<IllegalArgumentException> {
                    PurchaseAmount.from(input)
                }
                exception.message should startWith("구입 금액은 숫자여야 합니다.")
            }
        }

        `when`("1000원으로 나누어 떨어지는 수가 아니라면"){
            val input = "1444444"

            then("IllegalArgumentException 을 반환한다."){
                val exception = shouldThrow<IllegalArgumentException> {
                    PurchaseAmount.from(input)
                }
                exception.message should startWith("구입 금액은 1000원 단위만 가능합니다.")
            }
        }
    }
})