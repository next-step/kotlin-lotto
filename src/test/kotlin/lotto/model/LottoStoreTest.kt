package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class LottoStoreTest {
    @ParameterizedTest
    @MethodSource("buyTicketCountProvider")
    fun `상점에 돈을 주고 로또를 사면 1000원 당 한장의 LottoTicket 을 준다`(money: Money, ticketCount: Int) {
        val store = LottoStore()

        val result = store.buy(money)
        assertThat(result.size).isEqualTo(ticketCount)
    }

    companion object {
        @JvmStatic
        fun buyTicketCountProvider(): List<Arguments> {
            return listOf(
                Arguments { arrayOf(Money(1000), 1) },
                Arguments { arrayOf(Money(3000), 3) }
            )
        }
    }
}