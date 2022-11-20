package stringaddcalculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
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

    @CsvSource(
        value = ["1,2ㅁ3", "1,2,3ㅁ6", "1,2:3ㅁ6", "nullㅁ0"],
        delimiter = 'ㅁ',
        nullValues = ["null"]
    )
    @ParameterizedTest
    fun `기본 구분자 합계 기능 검증`(input: String?, expected: Int) {
        assertEquals(expected, PositiveNumbers(input).sum())
    }

    @Test
    fun `커스텀 구분자 합계 기능 검증`() {
        assertEquals(6, PositiveNumbers("//;\n1;2;3").sum())
    }
}
