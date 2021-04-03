package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class LottoStoreTest {
    @DisplayName("자동 로또 생성")
    @Test
    fun purchaseAuto() {
        val lottoTickets = LottoStore.purchaseAuto(PurchaseAmount("2000"), LottoCount(0), ONE_TO_SIX)
        assertThat(lottoTickets.tickets.size).isEqualTo(2)
    }

    @DisplayName("구매한 수동 로또가 있는 경우 수동 로또 수를 뺀 만큼 자동 로또 생성")
    @Test
    fun purchaseAuto2() {
        val lottoTickets = LottoStore.purchaseAuto(PurchaseAmount("2000"), LottoCount(1), ONE_TO_SIX)
        assertThat(lottoTickets.tickets.size).isEqualTo(1)
    }

    @DisplayName("수동 로또 생성")
    @Test
    fun purchaseManual() {
        val lottoTickets = LottoStore.purchaseManual(LottoCount(2)) {
            createLottoNumbers(1, 2, 3, 4, 5, 6)
        }
        assertThat(lottoTickets.tickets.size).isEqualTo(2)
    }
}
