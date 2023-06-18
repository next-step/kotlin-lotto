package lotto

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class InputParserTest {

    @Test
    fun `쉼표를 기준으로 당첨 번호를 구분한다`() {
        val input = "1, 2, 3, 4, 5, 6"
        InputParser.parse(input).size shouldBe 6
    }
}
