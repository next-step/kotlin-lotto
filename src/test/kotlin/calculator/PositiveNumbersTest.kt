package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.string.shouldInclude

class PositiveNumbersTest : StringSpec({

    "숫자 목록에 음수가 존재하면, 예외가 발생한다." {
        forAll(
            row(listOf(-1, -5, -2, -7)),
            row(listOf(-122, -254)),
            row(listOf(-32, -64))
        ) { numbers ->
            shouldThrow<IllegalArgumentException> {
                PositiveNumbers(numbers)
            }.message shouldInclude "숫자는 0 이상의 양수를 입력해주세요."
        }
    }
})
