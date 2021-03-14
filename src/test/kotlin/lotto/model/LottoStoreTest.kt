package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class LottoStoreTest {
    private val store = LottoStore()

    @ParameterizedTest
    @MethodSource("buyTicketCountProvider")
    fun `상점에 돈을 주고 로또를 사면 1000원 당 한장의 LottoTicket 을 준다`(money: Money, ticketCount: Int) {
        val result = store.buy(money)

        assertThat(result.size).isEqualTo(ticketCount)
    }

    companion object {
        @JvmStatic
        fun buyTicketCountProvider(): List<Arguments> {
            return listOf(
                Arguments { arrayOf(Money.thousand, 1) },
                Arguments { arrayOf(Money(3000), 3) },
                Arguments { arrayOf(Money(2500), 2) },
                Arguments { arrayOf(Money.zero, 0) }
            )
        }
    }
}
