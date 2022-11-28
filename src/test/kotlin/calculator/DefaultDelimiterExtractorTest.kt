package calculator

import calculator.domain.DefaultDelimiterExtractor
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import java.lang.IllegalArgumentException

class DefaultDelimiterExtractorTest : StringSpec({

    "기본 구분자는 : 또는 ,가 들어갈 수 있어요" {
        forAll(
            row("1:2"),
            row("1,2"),
        ) { text ->
            val extractor = DefaultDelimiterExtractor()
            val result = extractor.isValidExpression(text)

            result shouldBe true
        }
    }

    "기본 구분자외의 다른 구분자가 포함될 수 없어요." {
        forAll(
            row("1+2"),
            row("1/2"),
            row("1-2"),
        ) { text ->
            val extractor = DefaultDelimiterExtractor()
            val result = extractor.isValidExpression(text)

            result shouldBe false
        }
    }

    ", 또는 : 으로 값을 구분해요." {
        val extractor = DefaultDelimiterExtractor()
        val result = extractor.extract("1:4:99")

        result shouldBe listOf(1, 4, 99)
    }

    "기본 구분자 양식에 맞지 않는 수식이에요." {
        forAll(
            row("1+2"),
            row("1/2"),
            row("1-2"),
        ) { text ->
            shouldThrow<IllegalArgumentException> {
                val extractor = DefaultDelimiterExtractor()
                extractor.extract(text)
            }
        }
    }
})
