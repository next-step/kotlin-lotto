package calculator

import calculator.domain.CustomDelimiterExtractor
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import java.lang.IllegalArgumentException

class CustomDelimiterExtractorTest : StringSpec({

    "커스텀 구분자는 문자열 앞부분에 //와 \n가 포함되어야 해요." {
        val extractor = CustomDelimiterExtractor()
        val result = extractor.isValidExpression("//;\n")

        result shouldBe true
    }

    "커스텀 구분자로 값을 구분해요." {
        val extractor = CustomDelimiterExtractor()
        val result = extractor.extract("//;\n1;2")

        result shouldBe listOf(1, 2)
    }

    "커스텀 구분자가 포함된 양식에 맞지 않는 수식이에요." {
        forAll(
            row("//;\n"), // 수식이 없는 경우
            row(";\n1;2"), // 커스텀 구분자의 시작 문자인 //이 없는 경우
            row("//\n1;2"), // 커스텀 구분자가 없는 경우
            row("//;1;2") // 커스텀 구분자의 끝 문자인 \n이 없는 경우
        ) { text ->
            shouldThrow<IllegalArgumentException> {
                val extractor = CustomDelimiterExtractor()
                extractor.extract(text)
            }
        }
    }
})
