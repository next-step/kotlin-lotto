package stringcalculator.domain.customparser

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage

class ParserSeparatorsTest : DescribeSpec({
    it("getSize 는 구분자 리스트 size 를 가져온다") {
        // given
        val parserSeparators = ParserSeparators(listOf(ParserSeparator(":")))

        // when
        val size = parserSeparators.size

        // then
        val successSize = 1
        size shouldBe successSize
    }

    describe("validation") {
        it("ParserSeparators`(구분자들)가 없는 경우 IllegalArgumentException 가 발생한다") {
            // given
            val parserSeparators = listOf<ParserSeparator>()

            // then
            parserSeparators.size shouldBe 0
            shouldThrowExactly<IllegalArgumentException> {
                ParserSeparators(parserSeparators)
            }.shouldHaveMessage("숫자를 추출하기 위한 구분자가 없습니다")
        }
    }
})
