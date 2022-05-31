package lotto.seller

import lotto.agency.number.LottoNumberCache
import lotto.agency.number.LottoNumberMaker
import lotto.agency.number.LottoNumberStrategy
import lotto.exception.MinimumPurchaseMoneyException
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class LottoSellerTest {

    @Test
    fun `입력된 구입 금액만큼 로또를 n개 구입`() {
        val money = 13500
        val lottoSeller = LottoSeller()
        val lottoPurchaseAmount = lottoSeller.calculateLottoPurchaseAmount(money)
        val lottoNumberMaker = LottoNumberMaker()
        val purchaseLottoTickets = lottoSeller.buy(lottoPurchaseAmount, lottoNumberMaker)

        assertThat(purchaseLottoTickets.size).isEqualTo(lottoPurchaseAmount)
    }

    @Test
    fun `입력된 구입 금액이 1개를 구매할 수 있는 최소 금액이 넘지 않으면 에러처리`() {
        val money = 500
        val lottoSeller = LottoSeller()

        assertThatThrownBy { lottoSeller.calculateLottoPurchaseAmount(money) }
            .isInstanceOf(MinimumPurchaseMoneyException::class.java)
    }

    @Test
    fun `원하는 로또 티켓이 생성되었는지에 대한 테스트`() {
        class LottoNumberForTest : LottoNumberStrategy {
            override fun makeLottoNumbers(): Set<Int> {
                return setOf(1, 6, 23, 5, 2, 7)
            }
        }

        val lottoPurchaseAmount = 1
        val lottoSeller = LottoSeller()
        val lottoNumberForTest = LottoNumberForTest()
        val lottoTicket = lottoSeller.buy(lottoPurchaseAmount, lottoNumberForTest)
        val lottoNumbers = lottoNumberForTest.makeLottoNumbers().map { LottoNumberCache.valueOf(it) }.toSet()

        lottoNumbers.forEach {
            assertThat(lottoTicket[0].numbers).contains(it)
        }
    }
}
