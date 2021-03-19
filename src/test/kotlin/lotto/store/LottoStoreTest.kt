package lotto.store

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoStoreTest {

    @Test
    fun `지급된 금액만큼 로또발행-천원단위`() {
        // given
        val request = PurchaseRequest.ofTxAmount("2000")
        // when
        val tickets = LottoStore.purchase(request)
        // then
        assertThat(tickets.lottoTickets.size).isEqualTo(2)
    }
}
