package stringaddcalculator

import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import stringaddcalculator.domain.PositiveNumber

class PositiveNumberTest {

    @ValueSource(ints = [1, 2, 3, 4, 5])
    @ParameterizedTest
    fun `음수가 아닌 숫자 입력 객체 생성 - 성공`(input: Int) {
        assertDoesNotThrow {
            PositiveNumber(input)
        }
    }

    @ValueSource(ints = [-1, -2, -3, -4, -5])
    @ParameterizedTest
    fun `음수의 숫자 입력 객체 생성 - 실패`(input: Int) {
        assertThrows<RuntimeException> {
            PositiveNumber(input)
        }
    }

    @ValueSource(strings = ["1", "200", "3", "400", "50000"])
    @ParameterizedTest
    fun `음수가 아닌 문자열 입력 객체 생성 - 성공`(input: Int) {
        assertDoesNotThrow {
            PositiveNumber(input)
        }
    }

    @ValueSource(strings = ["-1", "-200", "-3", "-400", "-50000"])
    @ParameterizedTest
    fun `음수의 문자열 입력 객체 생성 - 실패`(input: Int) {
        assertThrows<RuntimeException> {
            PositiveNumber(input)
        }
    }
}
