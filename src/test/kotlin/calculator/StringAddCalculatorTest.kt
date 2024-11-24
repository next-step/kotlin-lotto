package calculator

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class StringAddCalculatorTest : DescribeSpec({
    lateinit var sut: StringAddCalculator

    describe("두 수의 합을 리턴한다") {
        beforeTest { sut = StringAddCalculator(1, 2) }
        it("accumulatedResult와 nextNumber를 더한 결과를 반환한다") {
            val result = sut.add()
            result shouldBe 3
        }
    }
})
