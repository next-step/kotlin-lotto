package calculator

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ParserTest: StringSpec({

    "빈 문자열을 입력할 경우 0을 반환해야 한다"{
        Parser.parse("") shouldBe listOf(0)
    }

    "null을 입력할 경우 0을 반환해야 한다"{
        Parser.parse(null) shouldBe listOf(0)
    }

    "숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다"{
        Parser.parse("1") shouldBe listOf(1)
    }

    "숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자를 반환한다."{
        Parser.parse("1,2") shouldBe listOf(1,2)
    }

    "숫자 두개를 콜론(:) 구분자로 입력할 경우 두 숫자를 반환한다."{
        Parser.parse("1:2") shouldBe listOf(1,2)

    }
})
