package stringcalculator

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContain

class StringParserTest : StringSpec({
    "//{구분자}\n 사이에 들어온 문자열은 커스텀한 구분자에 추가된다.." {
        val delimiters = StringParser.getDelimitersFromString("//^^\n1^^2")
        delimiters.delimiters shouldContain "^^"
    }
})
