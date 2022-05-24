package stringcalculator.domain.customparser

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.throwable.shouldHaveMessage

class PositiveNumberTest : DescribeSpec({
    describe("validation") {
        it("숫자가 음수 인 경우 IllegalArgumentException 발생") {
            // given
            val negativeNumber = -1

            // then
            shouldThrowExactly<IllegalArgumentException> {
                PositiveNumber(negativeNumber)
            }.shouldHaveMessage("음수($negativeNumber)은 입력할수 없습니다")
        }
    }
})
