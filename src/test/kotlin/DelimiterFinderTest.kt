import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class DelimiterFinderTest : DescribeSpec({
    it("기본 구분자를 반환한다.") {
        val expectDelimiters = DelimiterFinder.find("3,2")

        expectDelimiters shouldBe listOf(":", ",")
    }

    context("문자열 앞에 커스텀 구분자가 있다면") {
        it("기본 구분자와 함께 반환한다.") {
            val expectDelimiters = DelimiterFinder.find("//&\n3,2")

            expectDelimiters shouldBe listOf(":", ",", "&")
        }
    }
})
