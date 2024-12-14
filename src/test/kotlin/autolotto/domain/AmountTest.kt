package autolotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class AmountTest {
    @Test
    fun `금액이 0보다 크지 않으면 예외 발생`() {
        val exception =
            assertThrows<IllegalArgumentException> {
                Amount(0)
            }
        assertEquals("금액은 0보다 커야합니다.", exception.message)
    }

    @Test
    fun `로또 금액은 1000원단위만 입력 가능`() {
        val exception =
            assertThrows<IllegalArgumentException> {
                Amount(1500)
            }
        assertEquals("돈은 1000원 단위로만 입력 가능합니다.", exception.message)
    }

    @Test
    fun `정상적인 금액 입력시 로또 게임 수를 반환`() {
        val amount = Amount(5000)
        assertEquals(5, amount.lottoGameCount)
    }
}
