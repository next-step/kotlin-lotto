package lotto.domain

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec

internal class MoneyTest : BehaviorSpec({

    given("음수 값의 액수를 가진") {
        val amount = -1000

        `when`("Money 객체를 생성 시") {
            val throwableAction = { Money.of(amount) }

            then("IllegalArgumentException 예외를 발생한다.") {
                shouldThrow<IllegalArgumentException>(throwableAction)
            }
        }
    }

    given("양의 금액을 가진") {
        val amount = 1

        `when`("Moeny 객체를 생성 시") {
            val createMoney = { Money.of(amount) }

            then("주어진 금액을 가진 객체를 생성한다.") {
                shouldNotThrow<IllegalArgumentException>(createMoney)
            }
        }
    }
})
