package lotto.infra

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class RandomGeneratorFactoryTest {
    @DisplayName("사용자가 입력한 min,max 사이의 결과값을 리턴해야 한다")
    @Test
    fun minMax() {
        val numberGenerator = RandomGeneratorFactory(min, max).createNumberGenerator()
        val numbers = (min..max).map { numberGenerator() }
        assertThat(numbers.all { it in min..max }).isTrue
    }

    @DisplayName("같은 generator 가 생성한 숫자에는 중복이 없어야 한다.")
    @Test
    fun noDuplication() {
        val numberGenerator = RandomGeneratorFactory(min, max).createNumberGenerator()
        val numbers = (min..max).map { numberGenerator() }
        assertThat(numbers.distinct().size).isEqualTo(numbers.size)
    }

    @DisplayName("generator 가 생성할 수 있는 것보다 더 많이 생성하면 예외가 발생한다.")
    @Test
    fun exhausted() {
        val max = 5
        val numberGenerator = RandomGeneratorFactory(min, max).createNumberGenerator()
        assertThatExceptionOfType(NoSuchElementException::class.java)
            .isThrownBy { (min..(max + 10)).map { numberGenerator() } }
    }

    companion object {
        private const val min = 1
        private const val max = 45
    }
}
