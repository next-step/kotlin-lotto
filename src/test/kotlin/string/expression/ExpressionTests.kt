package string.expression

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ExpressionTests : StringSpec({

    "숫자를 더한 값을 반환환다" {
        val sut = Expression(listOf(1, 2, 3))
        sut.sum() shouldBe 6
    }
})
