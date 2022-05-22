package stringcalculator.domain.customparser

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage

class ParserSeparatorTest : DescribeSpec({
    it("ParserSeparator 는 문자열에서 숫자를 구분하기 위한 문자를 보관한다") {
        // given
        val separatorString = ";"
        val parserSeparator = ParserSeparator(separatorString)

        // then
        parserSeparator.string shouldBe separatorString
    }

    describe("validation") {
        it("\"\"(빈문자열)이 들어오면 IllegalArgumentException 발생") {
            // given
            val exceptionSeparatorString = ""

            // then
            shouldThrowExactly<IllegalArgumentException> {
                ParserSeparator(exceptionSeparatorString)
            }.shouldHaveMessage("구분자는 비워진 문자열로 넣을수 없습니다")
        }

        it("숫자가 들어가 있는 경우 IllegalArgumentException 발생") {
            // given
            val exceptionSeparatorString = "1"

            // then
            shouldThrowExactly<IllegalArgumentException> {
                ParserSeparator(exceptionSeparatorString)
            }.shouldHaveMessage("구분자는 숫자를 포함 할수 없습니다")
        }

        it("중간에 숫자가 포함되어 있는 경우 IllegalArgumentException 발생") {
            // given
            val exceptionSeparatorString = "!1!"

            // then
            shouldThrowExactly<IllegalArgumentException> {
                ParserSeparator(exceptionSeparatorString)
            }
        }
    }
})
