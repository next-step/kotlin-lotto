package study.lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class AmountTest {
    @Test
    fun `create Amount with positive value`() {
        val amount = Amount(100)
        assertEquals(100, amount.amount)
    }

    @Test
    fun `create Amount with zero value`() {
        val amount = Amount(0)
        assertEquals(0, amount.amount)
    }

    @Test
    fun `create Amount with negative value`() {
        assertThrows<IllegalArgumentException> {
            Amount(-50)
        }
    }

    @Test
    fun `add Amounts`() {
        val amount1 = Amount(50)
        val amount2 = Amount(30)
        val result = amount1 + amount2
        assertEquals(80, result.amount)
    }

    @Test
    fun `compare Amount with Int`() {
        val amount = Amount(50)
        val result1 = amount.compareTo(30)
        val result2 = amount.compareTo(70)
        assertEquals(50 - 30, result1)
        assertEquals(50 - 70, result2)
    }

    @Test
    fun `divide Amount`() {
        val amount = Amount(100)
        val result = amount / 25
        assertEquals(4, result)
    }
}
