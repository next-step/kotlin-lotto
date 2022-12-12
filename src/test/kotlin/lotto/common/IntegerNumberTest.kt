package lotto.common

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class IntegerNumberTest : StringSpec({
    "양수값을 가졌을때 isPositive 에서 true를 반환한다." {
        // given
        val integer = IntegerNumber(1)
        // when
        val actual = integer.isPositive()
        // then
        actual shouldBe true
    }

    "음수값을 가졌을때 isPositive 에서 false를 반환한다." {
        // given
        val integer = IntegerNumber(-1)
        // when
        val actual = integer.isPositive()
        // then
        actual shouldBe false
    }

    "양수값을 가졌을때 isNegative 에서 false를 반환한다." {
        // given
        val integer = IntegerNumber(1)
        // when
        val actual = integer.isNegative()
        // then
        actual shouldBe false
    }

    "음수값을 가졌을때 isNegative 에서 true를 반환한다." {
        // given
        val integer = IntegerNumber(-1)
        // when
        val actual = integer.isNegative()
        // then
        actual shouldBe true
    }

    "Double 변환 테스트" {
        // given
        val integer = IntegerNumber(1)
        // when
        val actual = integer.toDouble()
        // then
        actual shouldBe DoubleNumber(1.0)
    }

    "나눗셈 테스트" {
        // given
        val x = IntegerNumber(6)
        val y = IntegerNumber(2)
        // when
        val actual = x.divide(y)
        // then
        actual shouldBe IntegerNumber(3)
    }
})
