package lotto.common

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class DoubleNumberTest : StringSpec({
    "양수값을 가졌을때 isNegative 에서 false를 반환한다." {
        // given
        val double = DoubleNumber(1.0)
        // when
        val actual = double.isNegative()
        // then
        actual shouldBe false
    }

    "음수값을 가졌을때 isNegative 에서 true를 반환한다." {
        // given
        val double = DoubleNumber(-1.0)
        // when
        val actual = double.isNegative()
        // then
        actual shouldBe true
    }

    "제곱 테스트" {
        // given
        val double = DoubleNumber(2.0)
        // when
        val actual = double.pow(DoubleNumber(2.0))
        // then
        actual shouldBe DoubleNumber(4.0)
    }

    "곱셈 테스트" {
        // given
        val x = DoubleNumber(2.0)
        val y = DoubleNumber(3.0)
        // when
        val actual = x.multiply(y)
        // then
        actual shouldBe DoubleNumber(6.0)
    }

    "나눗셈 테스트" {
        // given
        val x = DoubleNumber(6.0)
        val y = DoubleNumber(3.0)
        // when
        val actual = x.divide(y)
        // then
        actual shouldBe DoubleNumber(2.0)
    }

    "소숫점 버림 테스트" {
        // given
        val double = DoubleNumber(1.2)
        // when
        val actual = double.floor()
        // then
        actual shouldBe DoubleNumber(1.0)
    }

    "x보다 y가 크거나 같으면 true를 반환한다." {
        // given
        val x = DoubleNumber(1.2)
        val y = DoubleNumber(1.1)
        // when
        val actual = x.isGreaterThanEquals(y)
        // then
        actual shouldBe true
    }
})
