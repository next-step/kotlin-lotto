package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class MoneyTest : FreeSpec({

    "Money 객체의 유효성 검증 테스트" - {
        "input이 null" {
            val input = null
            val exception =
                shouldThrow<IllegalArgumentException> { Money(input) }
            exception.message shouldBe "뭐라도 입력하세요"
        }
        "input이 빈 문자열" {
            val input = ""
            val exception =
                shouldThrow<IllegalArgumentException> { Money(input) }
            exception.message shouldBe "뭐라도 입력하세요"
        }
        "input이 스페이스바 문자열" {
            val input = " "
            val exception =
                shouldThrow<IllegalArgumentException> { Money(input) }
            exception.message shouldBe "뭐라도 입력하세요"
        }
        "input에 문자가 포함된 경우" {
            val input = "10000원"
            val exception =
                shouldThrow<IllegalArgumentException> { Money(input) }
            exception.message shouldBe "올바른 금액을 입력하세요"
        }
        "input이 양수가 아닌 경우" {
            val input = "-1000"
            val exception =
                shouldThrow<IllegalArgumentException> { Money(input) }
            exception.message shouldBe "올바른 금액을 입력하세요"
        }
        "input이 0원인 경우" {
            val input = "0"
            val exception =
                shouldThrow<IllegalArgumentException> { Money(input) }
            exception.message shouldBe "올바른 금액을 입력하세요"
        }
    }
})
