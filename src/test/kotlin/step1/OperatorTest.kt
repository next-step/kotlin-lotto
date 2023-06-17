package step1

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class OperatorTest : StringSpec({
    "두 수에 대해 Operator.ADD가 올바른 연산 결과를 반환한다" {
        Operator.ADD.execute(5, 3) shouldBe 8
    }
})
