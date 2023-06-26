package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PriceTest : StringSpec({

    "가격에 문자열이 들어갈 경우 IllegalArgumentException을 발생시킨다." {
        val exception = shouldThrow<IllegalArgumentException> { Price("string") }

        exception.message shouldBe "입력한 문자열이 숫자가 아닙니다."
    }

    "가격이 1000원 단위가 아닐 경우 IllegalArgumentException을 발생시킨다." {
        val exception = shouldThrow<IllegalArgumentException> { Price("12345") }

        exception.message shouldBe "구매금액은 1000원 단위로 입력 가능합니다."
    }

    "정상적인 금액 입력 시 Price를 생성한다." {
        val price = Price("1000")

        price.value shouldBe 1000
    }
})
