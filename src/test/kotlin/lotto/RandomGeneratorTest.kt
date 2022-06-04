package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class RandomGeneratorTest {
    @ParameterizedTest
    @CsvSource(value = ["6, 1, 45", "6, 10, 30", "6, 20, 30"])
    fun `랜덤한 로또를 발급한다`(count: Int, minNumber: Int, maxNumber: Int) {
        val lotto = RandomGenerater().generate(count, minNumber, maxNumber)
        assertThat(lotto.numbers.size).isEqualTo(count)
        assertThat(lotto.numbers.all { it in minNumber..maxNumber }).isEqualTo(true)
    }
}
