import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class NumbersTest {
    @Test
    fun `Numbers sum 테스트`() {
        val numbers = Numbers(listOf(1, 2, 3)).sum()
        assertEquals(6, numbers)
    }
}