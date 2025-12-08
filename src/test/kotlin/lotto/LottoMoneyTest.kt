package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class LottoMoneyTest : FreeSpec({

    "Money 객체의 유효성 검증 테스트" - {
        "input이 null" {
            val input = null
            val exception =
                shouldThrow<IllegalArgumentException> { LottoMoney(input) }
            exception.message shouldBe "올바른 금액을 입력하세요"
        }
        "input이 빈 문자열" {
            val input = ""
            val exception =
                shouldThrow<IllegalArgumentException> { LottoMoney(input) }
            exception.message shouldBe "올바른 금액을 입력하세요"
        }
        "input이 스페이스바 문자열" {
            val input = " "
            val exception =
                shouldThrow<IllegalArgumentException> { LottoMoney(input) }
            exception.message shouldBe "올바른 금액을 입력하세요"
        }
        "input에 문자가 포함된 경우" {
            val input = "10000원"
            val exception =
                shouldThrow<IllegalArgumentException> { LottoMoney(input) }
            exception.message shouldBe "올바른 금액을 입력하세요"
        }
        "input이 양수가 아닌 경우" {
            val input = "-1000"
            val exception =
                shouldThrow<IllegalArgumentException> { LottoMoney(input) }
            exception.message shouldBe "올바른 금액을 입력하세요"
        }
        "input이 0원인 경우" {
            val input = "0"
            val exception =
                shouldThrow<IllegalArgumentException> { LottoMoney(input) }
            exception.message shouldBe "올바른 금액을 입력하세요"
        }
        "1000원 단위가 아닐 때 (999원) 예외 발생" {
            val exception =
                shouldThrow<IllegalArgumentException> {
                    LottoMoney("999")
                }
            exception.message shouldBe "1000원 단위로 입력하세요"
        }
    }
})
