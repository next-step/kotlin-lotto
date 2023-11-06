package stringLettersCalculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class StringNumberTest {

    @Test
    fun `문자열 숫자를 입력하면 정수형 숫자를 반환하는 객체를 생성한다`() {
        // Given
        val numberString = "1"

        // When
        val actual = StringNumber(numberString)

        // Then
        assertThat(actual.toInt()).isEqualTo(1)
    }

    @Test
    fun `문자열이 숫자가 아닌 경우 에러를 반환한다`() {
        // Given
        val numberString = "!"

        // When & Then
        assertThrows<RuntimeException> {
            StringNumber(numberString)
        }
    }
    
    @Test
    fun `숫자가 음수인 경우 에러를 반환한다`() {
        // Given
        val numberString = "-1"

        // When & Then
        assertThrows<RuntimeException> {
            StringNumber(numberString)
        }
    }
}
