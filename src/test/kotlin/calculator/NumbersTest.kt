package calculator

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class NumbersTest {
    @Test
    fun `숫자 리스트의 합계를 계산한다`() {
        val numbers = Numbers.from(listOf("1", "2", "3"))

        numbers.sum() shouldBe 6
    }
}
