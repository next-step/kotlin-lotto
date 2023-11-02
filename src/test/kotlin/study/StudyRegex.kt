package study

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldHaveSize

val CUSTOM_DELIMITER_SEARCH = "//(.)\n(.*)"
val DEFAULT_DELIMITER = ",|:"

class StudyRegex : StringSpec({

    "샘플코드" {
        val result = Regex("//(.)\n(.*)").find("//;\n1;2;3")
        result?.let {
            println("커스텀델리미터 사용시 여기로 들어옴 [${it.destructured}]  value=[${it.value}] range=[${it.range}]")
        }
    }

    "쪼개는 메서드를 구현한다" {
        val tc1 = spliter("//;\n1;2;3")
        println(tc1)
        tc1 shouldHaveSize 3

        val tc2 = spliter("1:2:3")
        println(tc2)
        tc2 shouldHaveSize 3

        val tc3 = spliter("1:2,3")
        println(tc3)
        tc3 shouldHaveSize 3
    }
})

fun spliter(input: String): List<String> {
    val result = Regex(CUSTOM_DELIMITER_SEARCH).find(input)
    result?.let {
        val (delimiter, value) = it.destructured
        return value.split(delimiter)
    }
    return input.split(DEFAULT_DELIMITER.toRegex())
}
