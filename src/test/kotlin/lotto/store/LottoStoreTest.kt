package lotto.store

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

internal class LottoStoreTest {

    @Test
    fun `지급된 금액만큼 로또발행-천원단위`() {
        // given
        val request = PurchaseRequest.ofTxAmount("2000", listOf("1,2,3,4,5,6"))
        // when
        val tickets = LottoStore.purchase(request)
        // then
        assertThat(tickets.lottoTickets.size).isEqualTo(2)
    }

    @Test
    fun `구입금액보다 수동요청이 많을경우 예외발생`() {
        // given
        val request = PurchaseRequest.ofTxAmount(
            "1000",
            listOf("1,2,3,4,5,6", "1,2,3,4,5,6")
        )
        // when
        // then
        assertThrows<IllegalArgumentException> {
            assertThat(LottoStore.purchase(request)).isEqualTo(2)
        }
    }
}
