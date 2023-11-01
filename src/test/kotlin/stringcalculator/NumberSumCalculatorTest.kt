package stringcalculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class NumberSumCalculatorTest {

    @Test
    fun `숫자들의 합을 구하고 반환한다`() {
        // given
        val numberSumCalculator = NumberSumCalculator()
        var target = listOf(1, 2, 3)

        // when
        var result = numberSumCalculator.sum(target)

        // then
        assertThat(result).isEqualTo(6)

        // given
        target = listOf(1, 2, 3, 4, 5)

        // when
        result = numberSumCalculator.sum(target)

        // then
        assertThat(result).isEqualTo(15)

        // given
        target = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

        // when
        result = numberSumCalculator.sum(target)

        // then
        assertThat(result).isEqualTo(55)
    }
}

