package lotto.study

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 *
 * @author Leo
 */
class CollectionTest {

    @Test
    fun `Random 으로 꺼낼 시 size 변화 없는지`() {
        val numbers = listOf(1, 2, 3)
        val randomNumber = numbers.random()
        assertEquals(3, numbers.size)
    }

    @Test
    fun `sort 검증`() {
        val numbers = listOf(5, 3, 1)
        assertEquals(1, numbers.sorted().first())
    }

    @Test
    fun `나누기`() {
        val result = 7 / 3.0
        println(result)
    }

}
