package lotto.entity

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class LottoTest {
    @Test
    fun `Lotto have 6 numbers`() {
        val numbers = setOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(5),
            LottoNumber(6),
            LottoNumber(7),
        )
        assertEquals(6, Lotto(numbers = numbers).numbers.size)
    }

    @Test
    fun `Lotto have no duplicates`() {
        val numbers = setOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(5),
            LottoNumber(6),
        )
        org.junit.jupiter.api.assertThrows<IllegalArgumentException> { Lotto(numbers) }
    }
}
