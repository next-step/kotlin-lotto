package lotto.input

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class MoneyInputViewTest : FreeSpec({

    "Money 객체의 유효성 검증 테스트" - {
        "input이 null" {
            // given
            val input = null
            // when
            val exception =
                shouldThrow<IllegalArgumentException> { MoneyInputView.process(input) }
            // then
            exception.message shouldBe "뭐라도 입력하세요"
        }
        "input이 빈 문자열" {
            // given
            val input = ""
            // when
            val exception =
                shouldThrow<IllegalArgumentException> { MoneyInputView.process(input) }
            // then
            exception.message shouldBe "뭐라도 입력하세요"
        }
        "input이 스페이스바 문자열" {
            // given
            val input = " "
            // when
            val exception =
                shouldThrow<IllegalArgumentException> { MoneyInputView.process(input) }
            // then
            exception.message shouldBe "뭐라도 입력하세요"
        }
        "input에 문자가 포함된 경우" {
            // given
            val input = "10000원"
            // when
            val exception =
                shouldThrow<IllegalArgumentException> { MoneyInputView.process(input) }
            // then
            exception.message shouldBe "올바른 금액을 입력하세요"
        }
        "input에 숫자만 있는 경우" {
            // given
            val input = "10000"
            // when
            val money = MoneyInputView.process(input)
            // then
            money.price shouldBe 10000
        }
    }
})
