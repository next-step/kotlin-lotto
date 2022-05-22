package calculator.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ParamsTest {

    @Test
    fun `getParams 해피패스 테스트`() {
        Assertions.assertThat(Params("1;2;3").values).isEqualTo(listOf(1, 2, 3))
        Assertions.assertThat(Params("2,3,4").values).isEqualTo(listOf(2, 3, 4))
    }

    @Test
    fun `getParams 커스텀구분자 테스트`() {
        Assertions.assertThat(Params("//;\n1;2;3").values).isEqualTo(listOf(1, 2, 3))
        Assertions.assertThat(Params("//,\n2,3,4").values).isEqualTo(listOf(2, 3, 4))
        Assertions.assertThat(Params("//&\n1&2&3").values).isEqualTo(listOf(1, 2, 3))
    }

    @ParameterizedTest
    @ValueSource(strings = ["a,2,3", "4,a,6,7", "1,-1,5", "-1,6,4"])
    fun `파싱된 결과가 숫자 이외의 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 한다`(input: String) {
        assertThrows<RuntimeException> {
            Params(input)
        }
    }

    @Test
    fun `공백이 입력되면 0으로 처리한다`() {
        Assertions.assertThat(Params(" ").values).isEqualTo(listOf(0))
        Assertions.assertThat(Params("1, ,2").values).isEqualTo(listOf(1, 0, 2))
        Assertions.assertThat(Params(" ,1").values).isEqualTo(listOf(0, 1))
    }

    @Test
    fun `빈 문자열 입력되면 0으로 처리한다`() {
        Assertions.assertThat(Params("1,,2").values).isEqualTo(listOf(1, 0, 2))
        Assertions.assertThat(Params(",1").values).isEqualTo(listOf(0, 1))
        Assertions.assertThat(Params("1,").values).isEqualTo(listOf(1, 0))
    }

    @Test
    fun `null이 입력되면 0으로 처리한다`() {
        Assertions.assertThat(Params(null).values).isEqualTo(listOf(0))
    }
}
