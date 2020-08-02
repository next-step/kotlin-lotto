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
    fun how_much_buy_lotto() {
        val money = 10000
        val lotto = Lotto(money, candidateNumbers)

        val result = lotto.list.size

        assertThat(result).isEqualTo(10)
    }
}
