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
    fun get_rank() {
        val first = Lotto(listOf("1", "2", "3", "4", "5", "6"))
        val second = Lotto(listOf("1", "2", "3", "4", "5", "7"))
        val third = Lotto(listOf("1", "2", "3", "4", "5", "8"))
        val fourth = Lotto(listOf("1", "2", "3", "4", "8", "9"))
        val fifth = Lotto(listOf("1", "2", "3", "8", "9", "10"))
        val no = Lotto(listOf("1", "2", "8", "9", "10", "11"))
        val correct = Lotto(listOf("1", "2", "3", "4", "5", "6"))
        val bonusBall = Number("7")

        val firstRank = first.getRank(correct.numbers, bonusBall)
        val secondRank = second.getRank(correct.numbers, bonusBall)
        val thirdRank = third.getRank(correct.numbers, bonusBall)
        val fourthRank = fourth.getRank(correct.numbers, bonusBall)
        val fifthRank = fifth.getRank(correct.numbers, bonusBall)
        val noRank = no.getRank(correct.numbers, bonusBall)

        assertThat(firstRank).isEqualTo("1등")
        assertThat(secondRank).isEqualTo("2등")
        assertThat(thirdRank).isEqualTo("3등")
        assertThat(fourthRank).isEqualTo("4등")
        assertThat(fifthRank).isEqualTo("5등")
        assertThat(noRank).isEqualTo("No Rank")
    }
}
