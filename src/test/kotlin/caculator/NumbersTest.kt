package caculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class NumbersTest {

    @Test
    fun sumOfNumbers() {
        val result = Numbers(listOf(Number(1), Number(2))).sum()
        assertThat(result).isEqualTo(3)
    }
}
