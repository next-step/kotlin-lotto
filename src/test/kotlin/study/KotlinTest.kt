package study

import lotto.view.ResultLotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class KotlinTest {
    @Test
    fun shuffleTest() {
        val list = List(45) { i -> i + 1 }
        val shuffledNumbers = list.shuffled()
        val lottoNumbers = list.subList(0, 6)
        println(shuffledNumbers)
        assertThat(lottoNumbers).containsExactly(1, 2, 3, 4, 5, 6)
    }

    @Test
    fun setEnumTest() {
        ResultLotto.plusCount(0)
        assertThat(ResultLotto.getCount(0)).isEqualTo(1)
    }
}
