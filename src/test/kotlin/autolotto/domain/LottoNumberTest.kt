package autolotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoNumberTest {
    @Test
    fun `로또 번호가 6개 아니면 예외`() {
        val exception =
            assertThrows<IllegalArgumentException> {
                LottoNumber(setOf(1, 2, 3, 4, 5))
            }
        assertEquals("로또 번호는 6개여야 합니다.", exception.message)
    }

    @Test
    fun `로또 번호가 1~45 범위를 벗어나면 예외`() {
        val exception =
            assertThrows<IllegalArgumentException> {
                LottoNumber(setOf(1, 2, 3, 4, 5, 46))
            }
        assertEquals("로또 번호는 1~45 사이여야 합니다.", exception.message)
    }

    @Test
    fun `타켓번호 포함 여부 동작 확인`() {
        val lottoNumber = LottoNumber(setOf(1, 2, 3, 4, 5, 6))
        assertTrue(lottoNumber.hasNumber(3))
    }

    @Test
    fun `타겟여부 미포함 확인`() {
        val lottoNumber = LottoNumber(setOf(1, 2, 3, 4, 5, 6))
        assertFalse(lottoNumber.hasNotNumber(3))
    }
}
