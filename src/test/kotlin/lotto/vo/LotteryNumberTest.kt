package lotto.vo

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec

internal class LotteryNumberTest : BehaviorSpec({
    given("1 미만의 숫자로") {
        val value = 0

        `when`("로또 번호 생성시") {
            val throwableAction = { LotteryNumber(value) }

            then("예외가 발생한다.") {
                shouldThrow<IllegalArgumentException>(throwableAction)
            }
        }
    }

    given("45 초과의 숫자로") {
        val value = 46

        `when`("로또 번호 생성시") {
            val throwableAction = { LotteryNumber(value) }

            then("예외가 발생한다.") {
                shouldThrow<IllegalArgumentException>(throwableAction)
            }
        }
    }
})
