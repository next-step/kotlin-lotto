package lotto.entity

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class LottoTest {
    @Test
    fun `Lotto have 6 numbers`() {
        assertEquals(6, Lotto.ticketing("1000")[0].numbers.size)
    }

    @Test
    fun `Lotto have no duplicates`() {
        org.junit.jupiter.api.assertThrows<NumberFormatException> { Lotto.ticketing("jeff") }
    }
}
