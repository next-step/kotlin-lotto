package lotto.seller

import lotto.FixtureBuilder.Companion.RandomNumberFixture
import lotto.agency.number.LottoNumber
import lotto.agency.number.LottoNumberMaker
import lotto.exception.MinimumPurchaseMoneyException
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class LottoSellerTest {

    @Test
    fun `입력된 구입 금액만큼 로또를 자동 n개 구입`() {
        val money = 13500
        val manualAmount = 0
        val lottoSeller = LottoSeller()
        val autoLottoPurchaseAmount = lottoSeller.calculateAutoLottoPurchaseAmount(money, manualAmount)
        val autoLottoNumberMaker = LottoNumberMaker()
        val purchaseLottoTickets = lottoSeller.buy(autoLottoPurchaseAmount, emptyList(), autoLottoNumberMaker)

        assertThat(purchaseLottoTickets.size).isEqualTo(autoLottoPurchaseAmount)
    }

    @Test
    fun `입력된 구입 금액이 1개를 구매할 수 있는 최소 금액이 넘지 않으면 에러처리`() {
        val money = 500
        val manualAmount = 0
        val lottoSeller = LottoSeller()

        assertThatThrownBy { lottoSeller.calculateAutoLottoPurchaseAmount(money, manualAmount) }
            .isInstanceOf(MinimumPurchaseMoneyException::class.java)
    }

    @Test
    fun `원하는 랜덤 로또 티켓이 생성되었는지에 대한 테스트`() {

        val autoLottoPurchaseAmount = 1
        val lottoSeller = LottoSeller()
        val randomNumbers = RandomNumberFixture(setOf(1, 6, 23, 5, 2, 7))
        val lottoTicket = lottoSeller.buy(autoLottoPurchaseAmount, emptyList(), randomNumbers)
        val lottoNumbers = randomNumbers.makeLottoNumbers().map { LottoNumber.valueOf(it) }.toSet()

        lottoNumbers.forEach {
            assertThat(lottoTicket[0].numbers).contains(it)
        }
    }

    @Test
    fun `원하는 수동 로또 티켓이 생성되었는지에 대한 테스트`() {

        val autoLottoPurchaseAmount = 0
        val manualLottoNumbers = listOf(setOf(4, 5, 6, 7, 8, 9))
        val lottoSeller = LottoSeller()
        val lottoNumberForTest = LottoNumberMaker()
        val lottoTicket = lottoSeller.buy(autoLottoPurchaseAmount, manualLottoNumbers, lottoNumberForTest)
        val lottoNumbers = manualLottoNumbers[0].map { LottoNumber.valueOf(it) }.toSet()

        lottoNumbers.forEach {
            assertThat(lottoTicket[0].numbers).contains(it)
        }
    }
}
