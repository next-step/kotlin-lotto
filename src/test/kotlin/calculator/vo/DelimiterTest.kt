package calculator.vo

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.FreeSpec
import io.kotest.data.forAll
import io.kotest.data.row

class DelimiterTest : FreeSpec({
    "숫자는 구분자가 될 수 없다." - {
        forAll(
            row('0'),
            row('1'),
            row('2'),
            row('3'),
            row('4'),
            row('5'),
            row('6'),
            row('7'),
            row('8'),
            row('9'),
        ) { input ->
            shouldThrowWithMessage<IllegalArgumentException>("숫자는 구분자가 될 수 없습니다.") {
                Delimiter(input)
            }
        }
    }
})
