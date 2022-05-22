package stringcalculator.domain.customparser

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class ParserSeparatorsTest : DescribeSpec({
    it("getSize 는 구분자 리스트 size 를 가져온다") {
        // given
        val parserSeparators = ParserSeparators(listOf())

        // when
        val size = parserSeparators.size

        // then
        val successSize = 0
        size shouldBe successSize
    }
})
