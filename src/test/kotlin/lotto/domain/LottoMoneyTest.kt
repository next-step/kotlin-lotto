package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoMoneyTest {

    @Test
    fun `로또 구입 개수를 계산한다`() {
        val lottoMoney = LottoMoney(14000)
        assertEquals(14, lottoMoney.calculateLottoCount())
    }

    @Test
    fun `로또 구입 금액은 0원 이상이어야 한다`() {
        assertThrows<IllegalArgumentException> {
            LottoMoney(-1)
        }
    }

    @Test
    fun `로또 구입 개수를 계산 시 1000원 미만 단위는 버림한다`() {
        val lottoMoney = LottoMoney(1500)
        assertEquals(1, lottoMoney.calculateLottoCount())
    }
}
