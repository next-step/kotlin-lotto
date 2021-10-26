package calculator

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class PositiveNumbersTest {

    @ParameterizedTest
    @ValueSource(
        strings = [
            "-1,2,3",
            "5,6,-7"
        ]
    )
    fun `분리된 숫자는 음수를 전달받으면 IllegalArgumentException 예외가 발생한다`(input: String) {
        val numbers = input.split(",").map { it.toInt() }
        assertThrows<IllegalArgumentException> { PositiveNumbers(numbers) }
    }
}
