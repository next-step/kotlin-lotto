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

    @Test
    fun `입력된 로또 번호를 구분자를 이용해 List 로 만들어 준다`() {
        val jackpotList = lottoShop.getJackpotNumbers(JACKPOT_NUMBERS).lotto
        val expectedList = LOTTO

        assertEquals(expectedList, jackpotList)
    }

    companion object {
        private const val MONEY = 14000
        private const val LOTTO_COUNT = 14
        private const val LOTTO_TRY_COUNT = 4
        private const val JACKPOT_NUMBERS = "1, 2, 3, 4, 5, 6"
        private val LOTTO = listOf(1, 2, 3, 4, 5, 6)
    }
}
