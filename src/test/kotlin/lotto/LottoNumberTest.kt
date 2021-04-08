package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoNumberTest {

    @Test
    fun `로또 번호 확인 - 정상`() {
        LottoNumber(listOf(1, 2, 3, 4, 5, 6))
    }

    @Test
    fun `로또 번호 확인 - 적은 개수 error`() {
        assertThrows<IllegalArgumentException> {
            LottoNumber(listOf(1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `로또 번호 확인 - 최소 번호 error`() {
        assertThrows<IllegalArgumentException> {
            LottoNumber(listOf(0, 1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `로또 번호 확인 - 최대 번호 error`() {
        assertThrows<IllegalArgumentException> {
            LottoNumber(listOf(1, 2, 3, 4, 5, 46))
        }
    }
}
