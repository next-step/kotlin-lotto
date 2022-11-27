package lotto

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LottoNumberTest{
    @Test
    fun compareTest() {
        assertTrue(LottoNumber(3) < LottoNumber(4))
    }
}