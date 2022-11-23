package add_calculator
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import java.lang.RuntimeException

class OperandTest : BehaviorSpec({
    given("정수가 아닌 문자열이 주어진 상태") {
        val text = "가나"
        `when`("Operand 를 생성하면") {
            then("RuntimeException을 반환한다") {
                shouldThrow<RuntimeException> {
                    Operand(text)
                }
            }
        }
    }

    given("음수가 주어진 상태") {
        val text = "-1"
        `when`("Operand 를 생성하면") {
            then("RuntimeException을 반환한다") {
                shouldThrow<RuntimeException> {
                    Operand(text)
                }
            }
        }
    }
})
