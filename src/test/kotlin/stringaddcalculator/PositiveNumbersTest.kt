package stringaddcalculator

import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource
import stringaddcalculator.domain.PositiveNumbers

class PositiveNumbersTest {

    @ValueSource(strings = ["1,2", "1,2,3", "1,2:3", "//;\n1;2;3"])
    @NullAndEmptySource
    @ParameterizedTest
    fun `문자열 번호 목록 관리 객체 생성 - 성공`(input: String?) {
        assertDoesNotThrow {
            PositiveNumbers(input)
        }
    }

    @ValueSource(strings = ["1.2", "ㄱ,2,3"])
    @ParameterizedTest
    fun `문자열 번호 목록 관리 객체 생성 - 실패`(input: String?) {
        assertThrows<RuntimeException> {
            PositiveNumbers(input)
        }
    }
}
