package stringaddcalculator.domain

import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class NumbersTest {

    @Test
    fun `배열이 비어있을 경우 IllegalArgumentException 발생`() {
        assertThatIllegalArgumentException()
            .isThrownBy { Numbers(emptyList()) }
    }

    @ParameterizedTest
    @MethodSource
    fun `number 값의 합 반환`(numbers: Numbers, expected: Int) {
        assert(numbers.sum() == expected)
    }

    companion object {
        @JvmStatic
        fun `number 값의 합 반환`() = listOf(
            arrayOf(Numbers(listOf(Number.of("1"), Number.of("2"), Number.of("3"))), 6),
            arrayOf(Numbers(listOf(Number.of("1"), Number.of("2"), Number.of("3"), Number.of("4"))), 10),
            arrayOf(Numbers(listOf(Number.of("1"), Number.of("2"), Number.of("3"), Number.of("4"), Number.of("5"))), 15),
        )
    }

}
