package calculator

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class TokenizerTest : FunSpec({

    context("Tokenizer") {

        test("숫자 하나를 문자열로 입력할 경우") {
            Tokenizer.tokenize("1") shouldBe listOf("1")
        }

        test("숫자 두개를 쉼표(,) 구분자로 입력할 경우") {
            Tokenizer.tokenize("1,2") shouldBe listOf("1", "2")
        }

        test("구분자를 쉼표(,) 이외에 콜론(:)을 사용할 수 있다.") {
            Tokenizer.tokenize("1,2:3") shouldBe listOf("1", "2", "3")
        }

        test("//와 \\n 문자 사이에 커스텀 구분자를 지정할 수 있다.") {
            Tokenizer.tokenize("//;\n1;2;3") shouldBe listOf("1", "2", "3")
        }
    }
})
