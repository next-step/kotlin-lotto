package stringcalculator

import io.kotest.core.spec.style.FeatureSpec
import io.kotest.matchers.shouldBe

/**
 * @see DefaultSeparator
 */
class DefaultSeparatorTest : FeatureSpec({

    feature("separate") {
        scenario("커스텀 구분자가 있으면 해당 구분자로 구분한다.") {
            val input = "//;\n1;2;3"

            DefaultSeparator.separate(input) shouldBe listOf("1", "2", "3")
        }

        scenario("커스텀 구분자가 없으면 기본 구분자로 구분한다.") {
            val input = "1,2:3,4:5"

            DefaultSeparator.separate(input) shouldBe listOf("1", "2", "3", "4", "5")
        }
    }
})
