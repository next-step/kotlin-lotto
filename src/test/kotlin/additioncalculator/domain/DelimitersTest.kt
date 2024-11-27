package additioncalculator.domain

import additioncalculator.domain.Delimiters
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class DelimitersTest {
    @Test
    fun `기본 구분자를 포함하여 문자열을 토대로 모든 구분자를 찾아낼 수 있다`() {
        val delimiters = Delimiters(text = "//t\n" + "1t2,3:4")
        delimiters.findDelimiters().containsAll(listOf(",", ":", "t")) shouldBe true
    }
}
