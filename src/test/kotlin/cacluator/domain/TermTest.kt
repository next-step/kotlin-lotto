package cacluator.domain

import calculator.domain.Term
import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec

class TermTest : BehaviorSpec({
    given("숫자가 아닌 문자가 포함된 문자열이 있다") {
        val input = "!!1"
        `when`("해당 문자열로 초기화를 하면") {
            then("예외가 던져진다") {
                shouldThrow<RuntimeException> { Term(input) }
            }
        }
    }
    given("음수인 문자열이 있다") {
        val input = "-1"
        `when`("해당 문자열로 초기화를 하면") {
            then("예외가 던져진다") {
                shouldThrow<RuntimeException> { Term(input) }
            }
        }
    }
    given("0이상의 문자열이 있다") {
        val input = "1"
        `when`("0이상의 숫자가 들어오면") {
            then("정상적으로 생성된다") {
                shouldNotThrow<Throwable> { Term(input) }
            }
        }
    }
})
