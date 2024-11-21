package calculator

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class NumbersTest : StringSpec({

    "Numbers 는 유효한 Number 로 구성된 리스트를 와 Number 들의 합을 갖는다." {
        val number1 = Number(0)
        val number2 = Number(1)
        val number3 = Number(2)
        val numbers = Numbers(listOf(number1, number2, number3))

        numbers.sum shouldBe 3
    }
})
