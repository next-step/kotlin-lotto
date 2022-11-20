package calculator

import calculator.application.parser.impl.DelimiterParser
import calculator.application.parser.impl.ParsingException
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class DelimiterParserTest : FreeSpec({
    "구분자를 기준으로 숫자로 파싱할 수 있다" - {
        listOf(
            "23:42,11" to 3,
            "144,2" to 2,
            "1,444:6666:61,2" to 5
        ).forEach { (number: String, size: Int) ->
            "\"${number}\"의 숫자 리스트 원소의 개수는 ${size}개 입니다." {
                DelimiterParser.parse(number).size shouldBe size
            }
        }
    }

    "숫자가 아닌 값 혹은 음수가 들어가면 파싱 예외(RuntimeException)가 발생한다" - {
        listOf(
            "23:42,11!@",
            "144,-2",
            "1,0:66이피66:61,2"
        ).forEach { number: String ->
            "\"${number}\"는 파싱할 수 없는 값입니다." {
                shouldThrow<ParsingException> { DelimiterParser.parse(number) }
            }
        }
    }

    "커스텀 구분자를 추가할 수 있다." - {
        listOf(
            "//;\n1;3;5" to 3,
            "//!!\n1!!34!!5!!432!!4341" to 5
        ).forEach { (number: String, size: Int) ->
            "\"${number}\"의 숫자 리스트 원소의 개수는 ${size}개 입니다." {
                DelimiterParser.parse(number).size shouldBe size
            }
        }
    }
})
