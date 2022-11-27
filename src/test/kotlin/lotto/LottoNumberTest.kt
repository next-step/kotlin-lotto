package lotto

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LottoNumberTest{
    @Test
    fun `데이터 대소 비교 확인`() {
        assertTrue(LottoNumber(3) < LottoNumber(4))
    }

    @Test
    fun `LottoNumber 생성시 지정된 범위 내에서만 생성 가능`() {
        org.junit.jupiter.api.assertThrows<IllegalArgumentException> {
            LottoNumber(46)
        }
    }
}