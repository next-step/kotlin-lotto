package stringAddCalculator

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import stringAddCalculator.number.PositiveNumber
import java.lang.RuntimeException

class NumberTest {
    @ParameterizedTest
    @ValueSource(ints = [1, 10, 100, Int.MAX_VALUE])
    fun `PositiveNumber는 양수를 가질 수 있다`(value: Int) {
        PositiveNumber(value).validation() shouldBe true
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, -10, -100, -Int.MAX_VALUE])
    fun `PositiveNumber는 음수를 가질 수 없다`(value: Int) {
        assertThrows<RuntimeException>(ErrorCode.NOT_POSITIVE_NUMBER_ERROR.msg) {
            PositiveNumber(value).validation()
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["+", "@", "-", "양수", "음수"])
    fun `PositiveNumber는 숫자 이외의 값을 가질 수 없다`(value: Any) {
        assertThrows<RuntimeException>(ErrorCode.NOT_POSITIVE_NUMBER_ERROR.msg) {
            PositiveNumber(value as Int).validation()
        }
    }
}
