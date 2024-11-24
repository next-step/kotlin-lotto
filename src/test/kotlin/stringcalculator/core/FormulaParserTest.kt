package stringcalculator.core

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class FormulaParserTest {
    @Test
    fun `null일때 0을 반환함을 확인한다`() {
        FormulaParser.parse(null) shouldBe listOf(Number.ZERO)
    }

    @Test
    fun `빈문자일때 0을 반환함을 확인한다`() {
        FormulaParser.parse("") shouldBe listOf(Number.ZERO)
    }

    @Test
    fun `구분자로 정상적으로 분할됨을 확인한다`() {
        FormulaParser.parse("1,2;3") shouldBe listOf(Number("1"), Number("2"), Number("3"))
    }
}
