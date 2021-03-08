package caculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class NaturalNumbersTest {

    @Test
    fun sumOfNumbers() {
        val result = NaturalNumbers(listOf(NaturalNumber(1), NaturalNumber(2))).sum()
        assertThat(result).isEqualTo(3)
    }
}
