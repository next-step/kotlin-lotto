package cacluator.domain

import calculator.domain.Tokenizer
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class TokenizerTest : BehaviorSpec({

    given("커스텀 구분자로 구분된 문자열이 있다") {
        val input = "//?\n1?2?3?4"
        `when`("주어진 문자열을 토큰화 하면") {
            then("커스텀 구분자로 분할한다") {
                Tokenizer.getTokens(input) shouldBe listOf("1", "2", "3", "4")
            }
        }
    }

    given("유효한 문자열이 있다") {
        val input = "1,2:3,4"
        `when`("주어진 문자열을 토큰화 하면") {
            then("정상적으로 분할된다") {
                Tokenizer.getTokens(input) shouldBe listOf("1", "2", "3", "4")
            }
        }
    }
})
