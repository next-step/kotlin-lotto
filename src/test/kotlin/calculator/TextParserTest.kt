package calculator

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class TextParserTest : StringSpec({
    val sut = TextParser(listOf(DefaultDelimiterSplitter, CustomDelimiterSplitter))

    "문자열을 입력받으면 구분자를 기준으로 숫자들을 분리한다" {
        val text = "1,2:3"

        val actual = sut.parse(text)

        actual shouldBe listOf(1, 2, 3)
    }

    "커스텀 구분자가 있는 경우 커스텀 구분자를 기준에 추가하여 숫자들을 분리한다" {
        val text = "//;\n1;2;3"

        val actual = sut.parse(text)

        actual shouldBe listOf(1, 2, 3)
    }

    "문자열이 비어있는 경우 빈 리스트를 반환한다" {
        val text = ""

        val actual = sut.parse(text)

        actual shouldBe listOf()
    }

    "문자열이 null인 경우 빈 리스트를 반환한다" {
        val text = null

        val actual = sut.parse(text)

        actual shouldBe listOf()
    }
})

class TextParser(
    private val delimiterSplitters: List<DelimiterSplitter>,
) {
    fun parse(input: String?): List<Int> {
        if (input.isNullOrBlank()) {
            return DEFAULT_VALUE
        }

        val delimiterSplitter = delimiterSplitters.find { it.isSupport(input) } ?: DefaultDelimiterSplitter
        return delimiterSplitter.split(input).map(String::toInt)
    }
}

interface DelimiterSplitter {
    fun isSupport(text: String): Boolean

    fun split(text: String): List<String>
}

object DefaultDelimiterSplitter : DelimiterSplitter {
    private val DEFAULT_DELIMITER = Regex("[,:]")

    override fun isSupport(text: String): Boolean {
        return !text.startsWith("//")
    }

    override fun split(text: String): List<String> {
        return text.split(DEFAULT_DELIMITER)
    }
}

object CustomDelimiterSplitter : DelimiterSplitter {
    private val CUSTOM_DELIMITER = Regex("//(.)\n(.*)")
    private const val CUSTOM_DELIMITER_PREFIX = "//"

    override fun isSupport(text: String): Boolean {
        return text.startsWith(CUSTOM_DELIMITER_PREFIX)
    }

    override fun split(text: String): List<String> {
        val matchResult = CUSTOM_DELIMITER.find(text) ?: throw IllegalArgumentException("Invalid input")
        val (delimiter, numbers) = matchResult.destructured
        return numbers.split(delimiter)
    }
}

val DEFAULT_VALUE = listOf<Int>()
