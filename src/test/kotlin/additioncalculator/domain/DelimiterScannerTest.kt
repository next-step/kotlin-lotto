package additioncalculator.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class DelimiterScannerTest {
    @Test
    fun `기본 구분자를 포함하여 문자열을 토대로 모든 구분자를 찾아낼 수 있다`() {
        val findDelimiters = DelimiterScanner.findDelimiters(inputText = "//t\n" + "1t2,3:4")
        findDelimiters.containsAll(listOf(",", ":", "t")) shouldBe true
    }
}
