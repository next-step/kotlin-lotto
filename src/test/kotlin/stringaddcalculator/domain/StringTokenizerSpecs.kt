package stringaddcalculator.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldContainInOrder

class StringTokenizerSpecs : DescribeSpec({

    describe("문자열 토크나이저는") {
        it("구분자에 따라 주어진 문자열을 토큰화한다") {
            val input = "1,2:3"
            StringTokenizer().tokens(input) shouldContainInOrder listOf("1", "2", "3")
        }

        context("커스텀 구분자가 포함된 문자열이 주어진다면") {
            it("추가된 커스컴 구분자를 적용해 문자열을 토큰화한다") {
                val input = "//;\n1,2:3;4"
                StringTokenizer().tokens(input) shouldContainInOrder listOf("1", "2", "3", "4")
            }
        }
    }
})
