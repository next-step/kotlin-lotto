package stringCaculator.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import stringCaculator.domain.Seperator


class SeperatorTest{
    private val seperator = Seperator()

    @DisplayName(value = ",나 :로 문자열 분리를 할 수 있습니다")
    @Test
    fun defaultDelimeterSuccess() {
        Assertions.assertThat(seperator.parse("1,2,3,4,5")).isEqualTo(listOf(1,2,3,4,5))
        Assertions.assertThat(seperator.parse("1:2:3:4:5")).isEqualTo(listOf(1,2,3,4,5))
        Assertions.assertThat(seperator.parse("1:2,3:4,5")).isEqualTo(listOf(1,2,3,4,5))
    }

    @DisplayName(value = "//과 \\n이 포함되어 있으면 커스텀 구분자로 값을 구분합니다")
    @Test
    fun oneNumber() {
        Assertions.assertThat(seperator.parse("//-\n1-2-3")).isEqualTo(listOf(1,2,3))
        Assertions.assertThat(seperator.parse("//;\n1")).isEqualTo(listOf(1))
    }


    @DisplayName(value = "문자열 계산기에 음수를 전달하는 경우 RuntimeException 예외 처리를 한다.")
    @Test
    fun negative() {
        Assertions.assertThatExceptionOfType(RuntimeException::class.java)
            .isThrownBy { seperator.parse("-1,2,3,4,5") }
    }
}
