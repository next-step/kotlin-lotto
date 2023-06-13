package cacluator.domain

import calculator.domain.Term
import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec

class TermTest : BehaviorSpec({
    given("Term 생성시") {
        `when`("숫자가 아닌 문자가 포함되면") {
            then("예외가 던져진다") {
                shouldThrow<RuntimeException> { Term("!!1") }
            }
        }

        `when`("음수가 입력되면") {
            then("예외가 던져진다") {
                shouldThrow<RuntimeException> { Term("-1") }
            }
        }

        `when`("0이상의 숫자가 들어오면") {
            then("정상적으로 생성된다") {
                shouldNotThrow<Throwable> { Term("1") }
            }
        }
    }
})
