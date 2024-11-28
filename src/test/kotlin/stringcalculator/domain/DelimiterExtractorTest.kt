package stringcalculator.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class DelimiterExtractorTest : StringSpec(
    {
        "should extract custom delimiter and numbers part" {
            val extractor = DelimiterExtractor
            val (regex, numbersPart) = extractor.extract("//;\n1;2;3")
            regex.toString() shouldBe "[\\Q;\\E,:]"
            numbersPart shouldBe "1;2;3"
        }

        "should return default delimiters for basic input" {
            val extractor = DelimiterExtractor
            val (regex, numbersPart) = extractor.extract("3:5")
            regex.toString() shouldBe "[,:]"
            numbersPart shouldBe "3:5"
        }
    },
)
