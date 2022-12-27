package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class MoneyTest : StringSpec({
    "양수값을 가졌을때 isPositive 에서 true를 반환한다." {
        // given
        val integer = Money(1)
        // when
        val actual = integer.isPositive()
        // then
        actual shouldBe true
    }

    "음수값을 가졌을때 isPositive 에서 false를 반환한다." {
        // given
        val integer = Money(-1)
        // when
        val actual = integer.isPositive()
        // then
        actual shouldBe false
    }
})
