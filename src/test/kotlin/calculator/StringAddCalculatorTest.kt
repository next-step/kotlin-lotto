package calculator

import calculator.StringAddCalculator.add
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe


object StringAddCalculator {
    private const val FIND_DELIMITER_PATTERN = "(?<=//)(.*?)(?=\\n)"
    private const val FIND_ADD_TEXT_PATTERN = "(?<=\\n)(.*)"
    private val DELIMITER_REGEX = Regex(FIND_DELIMITER_PATTERN)
    private val ADD_TEXT_REGEX = Regex(FIND_ADD_TEXT_PATTERN)
    private val DEFAULT_DELIMITERS = listOf(",", ":")


    fun add(text: String?): Int {
        if (text.isNullOrBlank()) {
            return 0
        }
        return parse(text).sum()
    }

    private fun parse(text: String): List<Int> {
        val customDelimiter = DELIMITER_REGEX.find(text)?.value
        if(text.startsWith("//")) {

        }
        val addText = ADD_TEXT_REGEX.find(text)?.value
        val delimiters = customDelimiter?.let {
            DEFAULT_DELIMITERS + it
        } ?: DEFAULT_DELIMITERS
        val map = addText?.split(*delimiters.toTypedArray())
        val map1 = map?.map { it.toInt() }
        return map1.orEmpty()
    }
}

class StringAddCalculatorTest : StringSpec({
    "빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다" {
        listOf(null, "").forAll { text ->
            add(text) shouldBe 0
        }
    }

    "숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다" {
        add("1") shouldBe 1
    }

    "숫자 두개를 쉼표(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다" {
        add("1,2") shouldBe 3
    }

    "구분자를 쉼표(,) 이외에 콜론(:)을 사용할 수 있다" {
        add("1,2:3") shouldBe 6
    }

    """//와 \n 문자 사이에 커스텀 구분자를 지정할 수 있다""" {
        add("//;\n1;2;3") shouldBe 6
    }

    "문자열 계산기에 음수를 전달하는 경우 RuntimeException 예외 처리를 한다" {}
})
