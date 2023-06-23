package calculator.utils

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class TokenConverterTest {
    @DisplayName(value = "문자열 계산기의 convertTokensToNum 함수가 string 을 int 로 변환한다")
    @Test
    fun convertTokensToNum() {
        val tokens = listOf("1", "2", "3")
        Assertions.assertThat(TokenConverter.convertToInt(tokens)).isEqualTo(listOf(1, 2, 3))
    }

    @DisplayName(value = "Unhappy Path - 유효하지 않은 입력값에 대해 convertTokensToNum 함수가 예외를 처리한다")
    @Test
    fun convertTokensToNumWithInvalidValue() {
        val tokens = listOf("1", "2", "@")
        assertThrows<RuntimeException> {
            TokenConverter.convertToInt(tokens)
        }
    }
}
