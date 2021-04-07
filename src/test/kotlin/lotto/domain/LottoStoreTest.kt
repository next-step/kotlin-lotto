package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class LottoStoreTest {
    @DisplayName("자동 로또와 수동 로또 생성")
    @Test
    fun purchase() {
        val lottoTickets = LottoStore.purchase(PurchaseAmount("3000"), LottoCount(2), ONE_TO_SIX) {
            createLottoNumbers(1, 2, 3, 4, 5, 6)
        }
        assertThat(lottoTickets.tickets.size).isEqualTo(3)
    }

    @DisplayName("자동 로또 생성")
    @Test
    fun purchaseAuto() {
        val lottoTickets = LottoStore.purchaseAuto(LottoCount(2), ONE_TO_SIX)
        assertThat(lottoTickets.size).isEqualTo(2)
    }

    @DisplayName("수동 로또 생성")
    @Test
    fun purchaseManual() {
        val lottoTickets = LottoStore.purchaseManual(LottoCount(2)) {
            createLottoNumbers(1, 2, 3, 4, 5, 6)
        }
        assertThat(lottoTickets.size).isEqualTo(2)
    }
}
