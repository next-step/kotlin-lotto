package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class LottoShopTest {

    @ParameterizedTest
    @CsvSource("1000,1", "3500, 3", "5000, 5", "9999, 9")
    fun `구매 금액에 맞는 로또를 생성한다`(money: Int, buyCount: Int) {
        val buyLotto = LottoShop(money).autoPurchase()
        assertThat(buyLotto.size).isEqualTo(buyCount)
    }

    @ParameterizedTest
    @ValueSource(ints = [999])
    fun `구매 금액이 적으면 로또를 생성하지 못한다`(money: Int) {
        assertThrows<RuntimeException> { LottoShop(money).autoPurchase() }
    }

    @Test
    fun `수동으로 입력한 번호로 로또를 구매한다`() {
        val money = 1000
        val lottoTicket = listOf(1, 2, 3, 4, 5, 6)
            .map(::LottoNumber)
            .let { LottoTicket.of(it) }

        val lottoBundle = LottoBundle(listOf(lottoTicket))

        val manualNumber = ManualPurchaseNumbers(lottoBundle)

        val manualLottoTickets = LottoShop(money).manualPurchase(manualNumber)
        val compareLottoTickets = listOf(lottoTicket)

        assertThat(manualLottoTickets).isEqualTo(compareLottoTickets)
    }

    @Test
    fun `구매 가능 로또 갯수 안에서 수동 로또 갯수를 설정할 수 있게 한다`() {
        val lottoShop = LottoShop(1000)
        assertThrows<RuntimeException> { lottoShop.autoPurchase(2) }
    }

    @Test
    fun `로또 구매하면, 구매가능한 숫자가 감소한다`() {
        val lottoShop = LottoShop(5000)
        lottoShop.autoPurchase(3)

        // invalid call
        assertThrows<RuntimeException> { lottoShop.autoPurchase(3) }
    }
}
