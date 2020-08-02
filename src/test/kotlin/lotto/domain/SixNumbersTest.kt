package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SixNumbersTest {
    private val candidateNumbers = makeCandidateNumbers()

    private fun makeCandidateNumbers(): List<String> {
        val list = mutableListOf<String>()
        for (number in 1..45) {
            list.add(number.toString())
        }
        return list
    }

    @Test
    fun has_six_Number() {
        val sixNumbers = SixNumbers(candidateNumbers.shuffled())

        val result = sixNumbers.list.size

        assertThat(result).isEqualTo(6)
    }
}
