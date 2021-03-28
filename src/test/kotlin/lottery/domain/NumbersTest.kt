package lottery.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class NumbersTest {
    @Test
    fun `두개의 숫자들을 합친 결과를 전달한다`() {
        val firstNumbers = Numbers(listOf(listOf(1, 2, 3, 4, 5, 6)))
        val secondNumbers = Numbers(listOf(listOf(10, 11, 12, 13, 14, 15)))

        val mergedNumbers = firstNumbers.merge(secondNumbers)

        assertThat(mergedNumbers).containsExactlyInAnyOrder(
            firstNumbers[0],
            secondNumbers[0]
        )
    }
}
