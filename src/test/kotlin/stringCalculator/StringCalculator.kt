package stringCalculator

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

class StringCalculator : AnnotationSpec() {

    @Test
    fun `쉽표 또는 콜론을 구분자로 인식한다`() {
        val strings = listOf("1,2,3", "1,2:3", "1:2:3")
        strings.forEach {
            StringPlusCalculator.seperate(it) shouldBe listOf(1, 2, 3)
        }
    }

    @Test
    fun ``() {
        val strings = listOf("//;\n1;2;3", "1,2:3", "1:2:3", "//;\n1,2;3", "//;\n1,2:3")
        strings.forEach {
            StringPlusCalculator.seperate(it) shouldBe listOf(1, 2, 3)
        }
    }
}
