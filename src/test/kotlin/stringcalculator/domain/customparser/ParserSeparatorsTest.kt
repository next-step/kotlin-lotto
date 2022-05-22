package stringcalculator.domain.customparser

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class ParserSeparatorsTest : DescribeSpec({
    it("ofStringExpression 팩토리는 ':', ',' 를 기본값으로 갖고 있다") {
        // given
        val parserSeparators = ParserSeparators.ofStringExpression()

        // when
        val separators = parserSeparators.separators

        // then
        val defaultSeparatorList = listOf(
            ParserSeparator(":"),
            ParserSeparator(",")
        )
        separators.size shouldBe defaultSeparatorList.size
        separators[0].string shouldBe defaultSeparatorList[0].string
        separators[1].string shouldBe defaultSeparatorList[1].string
    }

    it("toEmpty 는 구분자가 비워진 생성자이다") {
        // given
        val parserSeparators = ParserSeparators.toEmpty()

        // then
        parserSeparators.separators.size shouldBe 0
    }

    it("getSize 는 구분자 리스트 size 를 가져온다") {
        // given
        val parserSeparators = ParserSeparators.toEmpty()

        // when
        val size = parserSeparators.getSize()

        // then
        val successSize = 0
        size shouldBe successSize
    }

    it("add 는 구분자를 추가한다") {
        // given
        val parserSeparators = ParserSeparators.toEmpty()
        val separator = ParserSeparator(";")

        // when
        parserSeparators.add(separator)

        // then
        parserSeparators.separators[0] shouldBe separator
    }
})
