package lotto

import lotto.machine.LottoMachine
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoStoreTest {
    @Test
    fun `Return lottos according to count`() {
        // given
        val lottoStore = LottoStore()
        val order = Order(3000, 0, emptyList())
        val expected = 3

        // when
        val actual = lottoStore.sell(order, FakeMachine())

        // then
        assertThat(actual.size).isEqualTo(expected)
    }

    private class FakeMachine : LottoMachine {
        private val lotto =
            List(10) {
                Lotto((1..6).map { LottoNumber.of(it) })
            }

        override fun generate(order: Order): List<Lotto> {
            return lotto.subList(0, order.autoTicketNumber)
        }
    }
}
