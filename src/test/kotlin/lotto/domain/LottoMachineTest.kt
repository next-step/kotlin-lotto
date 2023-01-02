package lotto.domain

import lotto.domain.Lotto.Companion.PRICE
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoMachineTest {

    @Test
    fun `입력된 로또 티켓(전체 자동생성)에 따라 로또를 생성한다`() {
        val purchaseAmount = 14000
        val lottoTicket = LottoTicket(purchaseAmount = 14000)
        val lotto = LottoMachine().draw(lottoTicket)
        assertThat(lotto.size).isEqualTo(purchaseAmount / PRICE)
    }

    @Test
    fun `입력된 로또 티켓(전체 수동생성)에 따라 로또를 생성한다`() {
        val purchaseAmount = 2000
        val manualLottoNumbers = listOf(
            listOf(1, 2, 3, 4, 5, 6),
            listOf(1, 2, 3, 4, 5, 6)
        )
        val lottoTicket = LottoTicket(purchaseAmount = purchaseAmount, manualLottoNumbers = manualLottoNumbers)
        val lotto = LottoMachine().draw(lottoTicket)
        assertThat(lotto.size).isEqualTo(purchaseAmount / PRICE)
    }

    @Test
    fun `입력된 로또 티켓(수동생성 + 자동생성)에 따라 로또를 생성한다`() {
        val purchaseAmount = 4000
        val manualLottoNumbers = listOf(
            listOf(1, 2, 3, 4, 5, 6),
            listOf(1, 2, 3, 4, 5, 6)
        )
        val lottoTicket = LottoTicket(purchaseAmount = purchaseAmount, manualLottoNumbers = manualLottoNumbers)
        val lotto = LottoMachine().draw(lottoTicket)
        assertThat(lotto.size).isEqualTo((purchaseAmount / PRICE))
    }
}
