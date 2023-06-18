package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldContain

class StringAddCalculatorTest : FreeSpec({

    "빈 문자열 또는 null 또는 공백을 입력할 경우 0을 반환한다." - {
        withData(
            nameFn = { "공백($it)" },
            null,
            "",
            "  ",
            "     "
        ) { input ->
            val sum = StringAddCalculator.calculate(input)
            sum shouldBe PositiveNumber.ZERO
        }
    }

    "1개의 숫자만 입력시 해당 숫자를 반환한다." - {
        withData(
            "3",
            "123",
            "12",
            "78"
        ) { input ->
            val sum = StringAddCalculator.calculate(input)
            sum shouldBe PositiveNumber(input)
        }
    }

    "콤마(,)로 문자열을 구분하여 더하기를 한다." - {
        withData(
            "1,2,3" to 6,
            "5,5,5" to 15,
            "30,20,10" to 60
        ) { (input, expected) ->
            val sum = StringAddCalculator.calculate(input)
            sum shouldBe PositiveNumber(expected)
        }
    }

    "콜론(:)으로 문자열을 구분하여 더하기를 한다." - {
        withData(
            "1:2:3" to 6,
            "3:6:7" to 16,
            "30:20:70" to 120
        ) { (input, expected) ->
            val sum = StringAddCalculator.calculate(input)
            sum shouldBe PositiveNumber(expected)
        }
    }

    "음수일 경우 runtime exception 을 발생한다." - {
        withData(
            "1,2:-3,4:-5",
            "-1,4",
            "12:3,-4:-5"
        ) { input ->
            val throws = shouldThrow<RuntimeException> {
                StringAddCalculator.calculate(input)
            }

            throws.message.shouldContain("음수는 입력할 수 없습니다.")
        }
    }

    "숫자가 아닐 경우 runtime exception 을 발생한다." - {
        withData(
            "a,2:-3,c:-5",
            "a,@!@#:-3,c:-5",
            "12:32:Rer:23:df"
        ) { input ->
            val throws = shouldThrow<RuntimeException> {
                StringAddCalculator.calculate(input)
            }

            throws.message.shouldContain("숫자 이외의 값은 입력할 수 없습니다.")
        }
    }

    "\"//\"와 \"\n\" 문자 사이에 커스텀 구분자를 지정할 수 있다. (예 : \"//;\n1;2;3\" => 6)" - {
        withData(
            "//;\n1;2;3" to 6,
            "//#\n7#8#9" to 24
        ) { (input, expected) ->
            val sum = StringAddCalculator.calculate(input)
            sum shouldBe PositiveNumber(expected)
        }
    }
})
