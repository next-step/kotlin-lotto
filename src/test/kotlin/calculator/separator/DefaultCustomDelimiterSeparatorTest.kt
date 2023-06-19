package calculator.separator

import calculator.vo.Delimiter
import io.kotest.core.spec.style.FreeSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class DefaultCustomDelimiterSeparatorTest : FreeSpec({

    "커스텀 구분자가 있는 경우" - {
        forAll(
            row("//a\\n1a2a3a4", Delimiter('a') to "1a2a3a4"),
            row("//;\\n1;2;3;4", Delimiter(';') to "1;2;3;4"),
            row("//?\\n1?2?3?4", Delimiter('?') to "1?2?3?4"),
        ) { input, expected ->
            val sut = DefaultCustomDelimiterSeparator

            val result = sut.separateFrom(input)

            result shouldBe expected
        }
    }

    "커스텀 구분자가 없는 경우 구분자 없이 기존 문자열을 그대로 반환한다" - {
        forAll(
            row("1,2,3,4", null to "1,2,3,4"),
            row("1:2:3:4:5", null to "1:2:3:4:5"),
            row("111,2:3,4", null to "111,2:3,4"),
        ) { input, expected ->
            val sut = DefaultCustomDelimiterSeparator

            val result = sut.separateFrom(input)

            result shouldBe expected
        }
    }
})
