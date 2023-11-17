package lotto.business

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTicketCounterTest {

    @Test
    fun `초기 로또 구매가능 수량은 받은 돈의 해당하는 로또 개수이다`() {
        // given
        val receivedAmount = ReceivedAmount(10000)

        // when
        val lottoTicketCounter = LottoTicketCounter(receivedAmount)

        // then
        assertThat(lottoTicketCounter.purchasableCount).isEqualTo(10000 / ReceivedAmount.LOTTO_PRICE)
    }

    @Test
    fun `로또 구매가능 수량을 감소시킬 수 있다`() {
        // given
        val receivedAmount = ReceivedAmount(10000)
        val lottoTicketCounter = LottoTicketCounter(receivedAmount)

        // when
        lottoTicketCounter.decreasePurchasableCount(1)

        // then
        val initCount = 10000 / ReceivedAmount.LOTTO_PRICE
        assertThat(lottoTicketCounter.purchasableCount).isEqualTo(initCount - 1)
    }

    @Test
    fun `구매한 로또 수량을 알 수 있다`() {
        // given
        val receivedAmount = ReceivedAmount(10000)
        val lottoTicketCounter = LottoTicketCounter(receivedAmount)

        // when
        lottoTicketCounter.decreasePurchasableCount(1)

        // then
        assertThat(lottoTicketCounter.usedTicketCount).isEqualTo(1)
    }
}
