package study

import io.kotest.core.spec.style.FunSpec

class RegExpTest : FunSpec({
    test("find 결과 값") {
        val text = "//;\n1;2;3"
        val result = Regex("//(.)\n(.*)").find(text)
        result?.let {
            println(it.groupValues[1])
            println(it.groupValues[2])
        }
    }
})
