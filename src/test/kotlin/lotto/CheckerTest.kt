package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CheckerTest {
    @Test
    fun `지난당첨번호와 일치하는 개수를 확인한다`() {
        val checker = Checker("1, 2,4,3,5")
        val lotto = Lotto().numbers
        assertThat(checker.match(lotto)).isEqualTo(2)
    }
}

class Checker(LastNumberText: String) {
    private val lastNumber: List<Int> = LastNumberText
        .split(",")
        .map { it.trim().toInt() }

    fun match(lotto: List<Int>): Int = lotto.filter { it in lastNumber }.size
}
