package lotto.input

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import lotto.domain.Money

class ManualCountInputViewTest : FreeSpec({

    "수동 구매 개수 입력 검증" - {
        "input이 null" {
            // given
            val input = null
            // when
            val exception =
                shouldThrow<IllegalArgumentException> { ManualCountInputView.process(Money(1000), input) }
            // then
            exception.message shouldBe "뭐라도 입력하세요"
        }
        "input이 빈 문자열" {
            // given
            val input = ""
            // when
            val exception =
                shouldThrow<IllegalArgumentException> { ManualCountInputView.process(Money(1000), input) }
            // then
            exception.message shouldBe "뭐라도 입력하세요"
        }
        "input이 스페이스바 문자열" {
            // given
            val input = " "
            // when
            val exception =
                shouldThrow<IllegalArgumentException> { ManualCountInputView.process(Money(1000), input) }
            // then
            exception.message shouldBe "뭐라도 입력하세요"
        }
        "input에 문자가 포함된 경우" {
            // given
            val input = "10000원"
            // when
            val exception =
                shouldThrow<IllegalArgumentException> { ManualCountInputView.process(Money(1000), input) }
            // then
            exception.message shouldBe "올바른 수동 구매수를 입력하세요"
        }
        "input에 숫자만 있는 경우" {
            // given
            val input = "1"
            // when
            val manualCount = ManualCountInputView.process(Money(1000), input)
            // then
            manualCount.count shouldBe 1
        }
    }
})
