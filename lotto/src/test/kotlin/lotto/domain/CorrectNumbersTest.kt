package lotto.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.matchers.string.shouldContain
import org.junit.jupiter.api.Test

class CorrectNumbersTest {

    @Test
    fun `당첨번호는 6개가 아닌 경우 예외가 발생한다`() {
        val inputs = List(5) { it }.toSet()

        val correctNumbers = shouldThrowExactly<IllegalArgumentException> {
            CorrectNumbers(inputs)
        }
        correctNumbers.message shouldContain "당첨 번호의 개수가 6개가 아닙니다"
    }
}
