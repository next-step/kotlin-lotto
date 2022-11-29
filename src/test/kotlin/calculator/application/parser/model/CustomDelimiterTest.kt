package calculator.application.parser.model

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe

class CustomDelimiterTest : FreeSpec({

    val delimiterPrefix = "//"
    val delimiterSuffix = "\n"

    "커스텀 구분자 적합" - {
        listOf(
            "${delimiterPrefix}o$delimiterSuffix" to "o",
            "$delimiterPrefix!$delimiterSuffix" to "!",
            "$delimiterPrefix%$delimiterSuffix" to "%"
        ).forEach { (delimiterString: String, customDelimiterValue: String) ->
            "$delimiterString 는 커스텀 구분자를 생성한다." {
                val customDelimiter = CustomDelimiter.findCustomDelimiters(delimiterString)
                customDelimiter.value shouldBe customDelimiterValue
            }
        }

        listOf(
            "${delimiterPrefix}o$delimiterSuffix",
            "$delimiterPrefix!$delimiterSuffix",
            "$delimiterPrefix%$delimiterSuffix"
        ).forEach { delimiterString: String ->
            "$delimiterString 는 커스텀 구분자를 가지고 있다." {
                CustomDelimiter.hasCustomDelimiter(delimiterString).shouldBeTrue()
            }
        }

        listOf(
            "$ delimiterPrefix-${delimiterSuffix}3,4-,6" to "-",
            "$delimiterPrefix!${delimiterSuffix}4!4,6" to "!",
            "$delimiterPrefix%${delimiterSuffix}8:4" to "%"
        ).forEach { (delimiterString: String, customDelimiterValue: String) ->
            "$delimiterString 는 " {
                val cleanDelimiter = CustomDelimiter.cleanDelimiter(delimiterString, customDelimiterValue)
                CustomDelimiter.hasCustomDelimiter(cleanDelimiter).shouldBeFalse()
            }
        }
    }

    "커스텀 구분자 부적합" - {
        listOf(
            "${delimiterPrefix}o",
            "!$delimiterSuffix",
            "%"
        ).forEach { delimiterString: String ->
            "$delimiterString 는 커스텀 구분자를 생성하지 못한다" {
                CustomDelimiter.hasCustomDelimiter(delimiterString).shouldBeFalse()
            }
        }
    }
})
