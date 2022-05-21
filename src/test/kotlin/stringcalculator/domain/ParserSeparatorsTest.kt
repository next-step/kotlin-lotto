package stringcalculator.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class ParserSeparatorsTest : DescribeSpec({
    it("ofStringExpression 팩토리는 ':', ',' 를 기본값으로 갖고 있다") {
        // given
        val parserSeparators = ParserSeparators.ofStringExpression()
        val defaultSeparatorList = listOf<ParserSeparator>(
            ParserSeparator(":"),
            ParserSeparator(",")
        )

        // when
        val separators = parserSeparators.separators

        // then
        separators.size shouldBe defaultSeparatorList.size
        separators[0].string shouldBe defaultSeparatorList[0].string
        separators[1].string shouldBe defaultSeparatorList[1].string
    }
})
