package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class LottoStoreTest {
    @DisplayName("자동 로또 생성")
    @Test
    fun purchaseAuto() {
        val lottoTickets = LottoStore.purchaseAuto(PurchaseAmount("2000"), ONE_TO_SIX)
        assertThat(lottoTickets.tickets.size).isEqualTo(2)
    }

    @DisplayName("수동 로또 생성")
    @Test
    fun purchaseManual() {
        val lottoTickets = LottoStore.purchaseManual(ManualCount(2)) {
            createLottoNumbers(1, 2, 3, 4, 5, 6)
        }
        assertThat(lottoTickets.tickets.size).isEqualTo(2)
    }
}
