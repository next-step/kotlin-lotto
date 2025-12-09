package lotto.input

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class MoneyInputViewTest : FreeSpec({

    "구입 금액 입력 검증" - {
        "null 입력 시 예외 발생" {
            // given
            val input = null
            // when
            val exception =
                shouldThrow<IllegalArgumentException> { MoneyInputView.process(input) }
            // then
            exception.message shouldBe "뭐라도 입력하세요"
        }
        "빈 문자열 입력 시 예외 발생" {
            // given
            val input = ""
            // when
            val exception =
                shouldThrow<IllegalArgumentException> { MoneyInputView.process(input) }
            // then
            exception.message shouldBe "뭐라도 입력하세요"
        }
        "스페이스바만 입력 시 예외 발생" {
            // given
            val input = " "
            // when
            val exception =
                shouldThrow<IllegalArgumentException> { MoneyInputView.process(input) }
            // then
            exception.message shouldBe "뭐라도 입력하세요"
        }
        "문자가 포함된 입력 시 예외 발생" {
            // given
            val input = "10000원"
            // when
            val exception =
                shouldThrow<IllegalArgumentException> { MoneyInputView.process(input) }
            // then
            exception.message shouldBe "올바른 금액을 입력하세요"
        }
        "올바른 숫자 입력 시 정상 처리" {
            // given
            val input = "10000"
            // when
            val money = MoneyInputView.process(input)
            // then
            money.price shouldBe 10000
        }
    }
})
