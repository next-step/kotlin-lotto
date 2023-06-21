package calculator

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class PositiveNumbersTest {

    @Test
    fun `문자열을 받아 객체를 생성한다`() {
        val positiveNumbers = PositiveNumbers.fromStrings(listOf("1", "2", "3"))

        positiveNumbers shouldBe PositiveNumbers(listOf(PositiveNumber(1), PositiveNumber(2), PositiveNumber(3)))
    }

    @Test
    fun `숫자의 합을 반환한다`() {
        val positiveNumbers = PositiveNumbers.fromStrings(listOf("1", "2", "3"))

        positiveNumbers.sum() shouldBe 6
    }
}
