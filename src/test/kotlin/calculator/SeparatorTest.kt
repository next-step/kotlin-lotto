package calculator

import calculator.domain.Separator
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class SeparatorTest : StringSpec({

    "//과 \n이 포함되어 있으면 커스텀 구분자로 값을 구분해요." {
        forAll(
            row("//-\n9-11-20", listOf(9, 11, 20)),
            row("//;\n10", listOf(10)),
        ) { expression, separatedNumber: List<Long> ->
            val separator = Separator()

            separator.separate(expression) shouldBe separatedNumber
        }
    }

    "커스텀 구분자가 존재하지 않으면 , 과 :로 값을 구분해요." {
        forAll(
            row("1,20:9", listOf(1, 20, 9)),
            row("10", listOf(10)),
        ) { expression, separatedNumber: List<Long> ->
            val separator = Separator()

            separator.separate(expression) shouldBe separatedNumber
        }
    }
})
