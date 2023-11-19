package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoShopTest {

    private val lottoShop = LottoShop()

    @Test
    fun `입력한 금액과 수동 로또의 갯수에 따라 로또 개수가 출력 된다`() {
        val lottoCount = lottoShop.countBuyLotto(MONEY, 3)
        assertEquals(11, lottoCount.autoLottoCount)
        assertEquals(3, lottoCount.manualLottoCount)
    }

    @Test
    fun `로또는 최소 1개는 사야 한다`() {
        assertThrows<IllegalArgumentException> {
            lottoShop.countBuyLotto(100, 0)
        }
    }

    @Test
    fun `lottoBuyCount 만큼 Lotto 가 만들어 진다`() {
        val lottoList = lottoShop.buyLotto(LOTTO_TRY_COUNT)
        assertEquals(4, lottoList.lottos.size)
    }

    @Test
    fun `입력된 로또 번호를 구분자를 이용해 List 로 만들어 준다`() {
        val jackpotList = lottoShop.generateLottoNumbers(JACKPOT_NUMBERS).lotto
        val expectedList = LOTTO

        assertEquals(expectedList, jackpotList)
    }

    @Test
    fun `로또 추첨을 하면 6개의 무작위 숫자가 뽑혀야 한다`() {
        val draw = lottoShop.buyLotto(3)
        assertEquals(LOTTO_SIZE, draw.lottos.size)
    }

    companion object {
        private const val MONEY = 14000
        private const val LOTTO_TRY_COUNT = 4
        private const val JACKPOT_NUMBERS = "1, 2, 3, 4, 5, 6"
        private val LOTTO = (1..6).map { LottoNumber(it) }
        private const val LOTTO_SIZE = 3
    }
}
