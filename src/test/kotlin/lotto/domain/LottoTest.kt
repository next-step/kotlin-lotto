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

    @Test
    fun how_many_correct_number() {
        val money = 1000
        val list = listOf("10", "3", "21", "14", "39", "1")
        val correctList = SixNumbers(listOf("3", "5", "21", "39", "40", "41"))
        val lotto = Lotto(money, list)

        lotto.result(correctList)

        assertThat(lotto.list[0].correctNumber).isEqualTo(3)
    }

    @Test
    fun how_much_get_money() {
        val money = 1000
        val list = listOf("10", "3", "21", "14", "39", "1")
        val correctList = SixNumbers(listOf("3", "5", "21", "39", "40", "41"))
        val lotto = Lotto(money, list)
        val testList = listOf(1.0, 0.0, 0.0, 0.0, 5.0)

        val result = lotto.result(correctList)

        assertThat(result).isEqualTo(testList)
    }
}
