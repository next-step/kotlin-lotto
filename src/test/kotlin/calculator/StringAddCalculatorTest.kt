package calculator

import io.kotest.core.spec.style.FunSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class StringAddCalculatorTest : FunSpec({
    val calculator by lazy { StringAddCalculator() }

    test("Returns 0 when the input is null or empty") {
        listOf(null, "", "   ").forAll {
            calculator.add(it) shouldBe 0
        }
    }
})
