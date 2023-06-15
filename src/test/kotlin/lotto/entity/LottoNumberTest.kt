package lotto.entity

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class LottoNumberTest {
    @Test
    fun `lotto number is in 1 ~ 45`() {
        org.junit.jupiter.api.assertThrows<IllegalArgumentException> { LottoNumber(0) }
        org.junit.jupiter.api.assertThrows<IllegalArgumentException> { LottoNumber(46) }
    }
}