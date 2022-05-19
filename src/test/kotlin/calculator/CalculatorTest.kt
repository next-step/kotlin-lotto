package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CalculatorTest {

    @Test
    fun `입력 값이 빈스트링인 경우 0의 원소를 갖는 List 반환`() {
        assertThat(Calculator.split("")).isEqualTo(listOf(0))
    }

    @Test
    fun `입력 값이 쉼표로 구분된 스트링인 경우 숫자 n개의 원소를 갖는 List 반환`() {
        assertThat(Calculator.split("1,2")).isEqualTo(listOf(1, 2))
    }

    @Test
    fun `입력 값이 콜론으로 구분된 스트링인 경우 숫자 n개의 원소를 갖는 List 반환`() {
        assertThat(Calculator.split("1:2")).isEqualTo(listOf(1, 2))
    }

    @Test
    fun `입력 값이 쉼표 또는 콜론으로 구분된 스트링인 경우 숫자 n개의 원소를 갖는 List 반환`() {
        assertThat(Calculator.split("1,2:3")).isEqualTo(listOf(1, 2, 3))
    }
}
