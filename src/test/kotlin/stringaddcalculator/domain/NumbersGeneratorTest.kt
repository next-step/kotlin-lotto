package stringaddcalculator.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class NumbersGeneratorTest {
    @Test
    fun `',' 기준으로 숫자를 나눠서 Number 리스트 반환`() {
        val numbers = NumbersGenerator("1,2,3").generate()
        assertThat(numbers)
            .isEqualTo(Numbers(listOf(Number.of("1"), Number.of("2"), Number.of("3"))))
    }

    @Test
    fun `콜론 기준으로 숫자를 나눠서 Number 리스트 반환`() {
        val numbers = NumbersGenerator("1:2:3").generate()
        assertThat(numbers)
            .isEqualTo(Numbers(listOf( Number.of("1"), Number.of("2"), Number.of("3"))))
    }

    @Test
    fun `쉼표와 콜론을 기준으로 숫자를 나눠서 Number 리스트 반환`() {
        val numbers = NumbersGenerator("1,2:3").generate()
        assertThat(numbers)
            .isEqualTo(Numbers(listOf( Number.of("1"), Number.of("2"), Number.of("3"))))
    }
}
