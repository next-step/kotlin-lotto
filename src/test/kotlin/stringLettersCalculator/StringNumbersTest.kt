package stringLettersCalculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StringNumbersTest {

    @Test
    fun `Number 클래스들의 콜랙션을 주입해서 Numbers 라는 일급 콜랙션을 생성한다`() {
        // Given
        val stringNumbers = listOf("1", "2")

        // When
        val actual = StringNumbers.from(stringNumbers)

        // Then
        assertThat(actual).usingRecursiveComparison()
            .isEqualTo(
                StringNumbers(listOf(StringNumber("1"), StringNumber("2")))
            )
    }

    @Test
    fun `숫자들의 합을 알 수 있다`() {
        // Given
        val givenNumbers = listOf("1", "2")
        val stringNumber = StringNumbers.from(givenNumbers)

        // When
        val actual = stringNumber.sumNumbers()

        // Then
        assertThat(actual).isEqualTo(3)
    }
}