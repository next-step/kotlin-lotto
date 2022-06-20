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
    fun `구매가능 갯수 이상을 요청하면 에러를 발생시킨다`() {
        val lottoShop = LottoShop(1000)
        assertThrows<RuntimeException> { lottoShop.autoPurchase(2) }
    }
}
