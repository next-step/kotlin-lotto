package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTest {
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
        val lotto = Lotto(candidateNumbers.shuffled())

        val result = lotto.numbers.size

        assertThat(result).isEqualTo(6)
    }

    @Test
    fun sort_low_to_high() {
        val list = listOf("3", "2", "20", "10", "17", "40")
        val testList = listOf(Number("2"), Number("3"), Number("10"), Number("17"), Number("20"), Number("40"))

        val lotto = Lotto(list)

        assertThat(lotto.numbers).isEqualTo(testList)
    }

    @Test
    fun check_correct_number() {
        val list = listOf("3", "2", "20", "10", "17", "40")
        val lotto = Lotto(list)

        lotto.checkCorrect(Number("3"))

        assertThat(lotto.correctNumber).isEqualTo(1)
    }
}
