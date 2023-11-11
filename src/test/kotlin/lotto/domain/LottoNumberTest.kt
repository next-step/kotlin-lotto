package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoNumberTest {

    @Test
    fun `로또 번호는 1 ~ 45 사이의 숫자여야한다`() {
        val validNumber = 5
        val lottoNumber = LottoNumber(validNumber)
        assertEquals(validNumber, lottoNumber.number)
    }

    @Test
    fun `로또 번호는 1 ~ 45 사이의 숫자가 아니면 에러 발생`() {
        val validNumber = 50
        assertThrows<IllegalArgumentException> {
            LottoNumber(validNumber)
        }
    }
}
