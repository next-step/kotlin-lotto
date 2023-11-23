package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class NumbersTest {
    @Test
    fun `일치하는 숫자 카운팅`() {
        val numbers = Numbers(listOf(1, 2, 3, 4, 5, 6))
        val numbers2 = Numbers(listOf(1, 2, 3, 4, 5, 7))

        val numberMatched = numbers.amountOfNumberMatched(numbers2)

        assertThat(numberMatched).isEqualTo(5)
    }
}
