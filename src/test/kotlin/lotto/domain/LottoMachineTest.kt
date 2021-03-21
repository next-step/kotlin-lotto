package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class LottoMachineTest {
    @ParameterizedTest
    @CsvSource(
        "15000, 3, 12, 3, 15",
        "990000, 50, 940, 50, 990",
        "1000, 0, 1, 0, 1"
    )
    fun `로또 구매 테스트`(
        price: Int,
        manualLottoCount: Int,
        expectedAutomaticCount: Int,
        expectedManualLottoCount: Int,
        totalLottoCount: Int
    ) {
        val buyingPrice = LottoPrice(price)
        val manualNumbers = ManualNumbers((1..manualLottoCount).map { "1,2,3,4,5,6" })
        val buyingLotto = BuyingLotto(buyingPrice, manualNumbers)

        val lottoTicket = LottoMachine.buy(buyingLotto)
        assertThat(lottoTicket.automatics.size).isEqualTo(expectedAutomaticCount)
        assertThat(lottoTicket.manuals.size).isEqualTo(expectedManualLottoCount)
        assertThat(lottoTicket.getTickets().size).isEqualTo(totalLottoCount)
    }
}
