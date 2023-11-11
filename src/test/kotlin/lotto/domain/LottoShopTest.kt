package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoShopTest {

    private val lottoShop = LottoShop()

    @Test
    fun `입력한 금액에 따라 로또 개수가 출력 된다`() {
        val lottoCount = lottoShop.getLottoBuyCount(MONEY)
        assertEquals(LOTTO_COUNT, lottoCount)
    }

    @Test
    fun `로또는 최소 1개는 사야 한다`() {
        assertThrows<IllegalArgumentException> {
            lottoShop.getLottoBuyCount(100)
        }
    }

    @Test
    fun `lottoBuyCount 만큼 Lotto 가 만들어 진다`() {
        val lottoList = lottoShop.buyLotto(LOTTO_TRY_COUNT)
        assertEquals(4, lottoList.size)
    }

    companion object {
        private const val MONEY = 14000
        private const val LOTTO_COUNT = 14
        private const val LOTTO_TRY_COUNT = 4
    }
}
