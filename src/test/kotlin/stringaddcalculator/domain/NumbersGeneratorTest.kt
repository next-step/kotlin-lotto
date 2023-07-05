package stringaddcalculator.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class NumbersGeneratorTest {
    @Test
    fun `',' 기준으로 숫자를 나눠서 Number 리스트 반환`() {
        val numbers = NumbersGenerator().generate("1,2,3")
        assertThat(numbers)
            .isEqualTo(Numbers(listOf(Number.of("1"), Number.of("2"), Number.of("3"))))
    }

    @Test
    fun `콜론 기준으로 숫자를 나눠서 Number 리스트 반환`() {
        val numbers = NumbersGenerator().generate("1,2,3")
        assertThat(numbers)
            .isEqualTo(Numbers(listOf( Number.of("1"), Number.of("2"), Number.of("3"))))
    }

    @Test
    fun `커스텀 구분자를 기준으로 숫자를 나눠서 Number 리스트 반환`() {
        val numbers = NumbersGenerator().generate("//;\n1;2;3")
        assertThat(numbers)
            .isEqualTo(Numbers(listOf( Number.of("1"), Number.of("2"), Number.of("3"))))
    }

    @Test
    fun `쉼표와 콜론을 기준으로 숫자를 나눠서 Number 리스트 반환`() {
        val numbers = NumbersGenerator().generate("1,2:3")
        assertThat(numbers)
            .isEqualTo(Numbers(listOf( Number.of("1"), Number.of("2"), Number.of("3"))))
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "2", "3"])
    fun `숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환`(input: String) {
        val numbers = NumbersGenerator().generate(input)
        assertThat(numbers)
            .isEqualTo(Numbers(listOf(Number.of(input))))
    }
}
