package calculator

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe

class 구분자_추출_테스트 : StringSpec({

    "문자열에 커스텀 구분자 없이 쉼표(,)만 구분자로 있을 때, 구분자 객체는 기본 구분자 2개를 가진다" {
        listOf("1,2,3,4,5", "2,7,2,7", "63435,73734,6759,567").forEach {
            val delimiters = DelimiterParser.extractDelimiters(it)

            delimiters.values shouldHaveSize 2
            delimiters.values shouldContain ","
            delimiters.values shouldContain ":"
        }
    }

    "문자열에 커스텀 구분자 없이 콜론(:)만 구분자로 있을 때, 구분자 객체는 기본 구분자 2개를 가진다" {
        listOf("1:2:3:4:5", "2:7:2:7", "63435:73734:6759:567").forEach {
            val delimiters = DelimiterParser.extractDelimiters(it)

            delimiters.values shouldHaveSize 2
            delimiters.values shouldContain ","
            delimiters.values shouldContain ":"
        }
    }

    "문자열에 커스텀 구분자 없이 쉼표(,)와 콜론(:)아 구분자로 있을 때, 구분자 객체는 기본 구분자 2개를 가진다" {
        listOf("1:2:3,4,5", "2,7:2,7", "63435:73734,6759:567").forEach {
            val delimiters = DelimiterParser.extractDelimiters(it)

            delimiters.values shouldHaveSize 2
            delimiters.values shouldContain ","
            delimiters.values shouldContain ":"
        }
    }

    "문자열에 커스텀 구분자가 포함될 때, 구분자 객체는 3개의 구분자를 가진다" {
        forAll(
            row("""//;\n1;2;3;4;5""", ";"),
            row("""//;\n1;2;3,4:5""", ";"),
            row("""//^\n2^3,9""", "^"),
            row("""//x\n2x3,9""", "x"),
            row("""//%%\n63435%%73734,6759:567""", "%%"),
        ) { inputString: String, expect: String ->
            val delimiters = DelimiterParser.extractDelimiters(inputString)

            delimiters.values shouldHaveSize 3
            delimiters.values shouldContain ","
            delimiters.values shouldContain ":"
            delimiters.values shouldContain expect
        }
    }
})

class 순수_입력값_추출_테스트 : StringSpec({

    "문자열에 커스텀 구분자가 포함될 때, 맨 앞의 선언식을 제외한 순수 입력값을 반환한다." {
        forAll(
            row("""//;\n1;2;3;4;5""", "1;2;3;4;5"),
            row("""//^\n2^3^9""", "2^3^9"),
            row("""//%%\n63435%%73734%%6759%%567""", "63435%%73734%%6759%%567"),
            row("""//;\n1;2;3,4:5""", "1;2;3,4:5"),
            row("""//^\n2^3,9""", "2^3,9"),
            row("""//x\n2x3,9""", "2x3,9"),
            row("""//%%\n63435%%73734,6759:567""", "63435%%73734,6759:567"),
        ) { inputString: String, expect: String ->
            val 순수_입력값 = DelimiterParser.extractPureInput(inputString)

            순수_입력값 shouldBe expect
        }
    }

    "문자열에 커스텀 구분자가 포함되지 않을 때, 입력값 그대로 반환한다." {
        forAll(
            row("1,2,3,4,5", "1,2,3,4,5"),
            row("2,3,9", "2,3,9"),
            row("63435,73734,6759,567", "63435,73734,6759,567"),
            row("1:2:3:4:5", "1:2:3:4:5"),
            row("2:3:9", "2:3:9"),
            row("63435:73734:6759:567", "63435:73734:6759:567"),
            row("1,2:3:4,5", "1,2:3:4,5"),
            row("2,3:9", "2,3:9"),
            row("63435:73734,6759:567", "63435:73734,6759:567"),
        ) { inputString: String, expect: String ->
            val 순수_입력값 = DelimiterParser.extractPureInput(inputString)

            순수_입력값 shouldBe expect
        }
    }
})
