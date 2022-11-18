package calculator.domain

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class StringSplitTest : FreeSpec({

    "splitString" - {

        "한개의 문자열일 경우도 리스트로 반환된다." {
            val stringsplit = StringSplit("1")

            stringsplit.splitString() shouldBe listOf("1")
        }

        "콤마(,) 구분자 기준으로 문자열이 분리된다." {
            val stringsplit = StringSplit("1,2")

            stringsplit.splitString() shouldBe listOf("1", "2")
        }

        "콜론(:) 구분자 기준으로 문자열이 분리된다." {
            val stringsplit = StringSplit("1:2")

            stringsplit.splitString() shouldBe listOf("1", "2")
        }

        "콤마, 콜론 두개를 기준으로 문자열이 분리된다." {
            val stringsplit = StringSplit("1,2:3")

            stringsplit.splitString() shouldBe listOf("1", "2", "3")
        }

        "//와 \n 문자 사이에 커스텀 구분자를 기준으로 문자열이 분리된다." {
            val stringsplit = StringSplit("//;\n1;2;3")

            stringsplit.splitString() shouldBe listOf("1", "2", "3")
        }
    }
})
