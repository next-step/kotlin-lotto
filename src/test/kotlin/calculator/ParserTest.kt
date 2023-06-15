package calculator

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ParserTest: StringSpec({

    "빈 문자열을 입력할 경우 0을 반환해야 한다"{
        Parser.getOperand("") shouldBe 0
    }

    "null을 입력할 경우 0을 반환해야 한다"{
        Parser.getOperand(null) shouldBe 0
    }

    "숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다"{
        Parser.getOperand("1") shouldBe 1
    }
})
