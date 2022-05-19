package calculator

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.int
import io.kotest.property.checkAll
import io.kotest.property.exhaustive.exhaustive

class StringCalculatorTest : StringSpec({
    "문자열 덧셈 계산기는 유효하지 않은 문자열을 입력하는 경우 0을 반환한다." {
        val calculator = StringCalculator()
        forAll(
            row(""),
            row(null)
        ) { input ->
            calculator.add(input) shouldBe 0
        }
    }
    "문자열 덧셈 계산기는 단일 숫자 입력에 해당 숫자를 그대로 반환한다." {
        val calculator = StringCalculator()
        checkAll(Arb.int(10..100)) { input ->
            calculator.add(input.toString()) shouldBe input
        }
    }
    "문자열 덧셈 계산기는 숫자 두개와 구분자를 입력하는 경우 두 숫자의 합을 반환한다." {
        val calculator = StringCalculator()
        checkAll(
            Arb.int(0..9),
            Arb.int(10..19),
            Arb.int(20..29),
            listOf(',', ':').exhaustive(),
            listOf(':', ',').exhaustive()
        ) { left, right, extra, delimiterLeft, delimiterRight ->
            calculator.add("$left$delimiterLeft$right$delimiterRight$extra") shouldBe left + right + extra
        }
    }
    "문자열 덧셈 계산기는 숫자 두개와 커스텀 구분자를 입력하는 경우 두 숫자의 합을 반환한다." {
        val calculator = StringCalculator()
        checkAll(
            Arb.int(0..9),
            Arb.int(10..19),
            listOf(';', '!', '@', '$').exhaustive()
        ) { left, right, delimiter ->
            val customDelimiter = "//$delimiter\n"
            calculator.add("$customDelimiter$left$delimiter$right") shouldBe left + right
        }
    }
    "문자열 덧셈 계산기는 음수가 입력된 경우 RuntimeException 예외를 발생한다." {
        val calculator = StringCalculator()
        shouldThrowExactly<RuntimeException> {
            calculator.add("1,2,-3")
        }
    }
})
