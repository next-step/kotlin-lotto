package calculator

import io.kotest.assertions.throwables.shouldThrow
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

    "문자 사이에 커스텀 구분자를 지정할 수 있다."{
        Parser.parse("//;\n1:2") shouldBe listOf(1,2)
    }

    "음수를 전달할 경우 RuntimeException 예외가 발생해야 한다."{
        shouldThrow<IllegalArgumentException> {
            Parser.parse("-11:2") shouldBe listOf(-11,2)
        }.message shouldBe "양수만 입력할 수 있습니다."

    }
})
