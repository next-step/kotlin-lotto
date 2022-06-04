package camp.nextstep.lotto.ticket

import camp.nextstep.lotto.number.LottoNumber
import camp.nextstep.lotto.number.LottoNumbers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class LottoStoreTest {

    @DisplayName("주어진 금액만큼 로또 티켓을 교환할 수 있다.")
    @ParameterizedTest(name = "{0}원으로는 {1}장의 로또 티켓을 사고 {2}원이 남는다.")
    @CsvSource(
        delimiter = ',',
        value = [
            "1000,1,0",
            "5000,5,0",
            "15500,15,500",
            "500,0,500",
            "0,0,0"
        ]
    )
    fun exchangeLottoTicketsTest(money: Int, expectedTicketCount: Int, expectedBalance: Int) {
        val lottoPrice = 1000
        val lottoStore = LottoStore(lottoTicketPrice = lottoPrice, lottoTicketMachine = LottoTicketMachine())

        val (tickets, balance) = lottoStore.exchangeAll(money)
        assertEquals(expectedTicketCount, tickets.size)
        assertEquals(expectedBalance, balance)
    }

    @DisplayName("주어진 번호에 대한 로또 티켓을 교환할 수 있다.")
    @Test
    fun exchangeLottoManually() {
        val lottoPrice = 1000
        val lottoStore = LottoStore(lottoTicketPrice = lottoPrice, lottoTicketMachine = LottoTicketMachine())

        val seedMoney = 1000
        val numbers = listOf(LottoNumbers.of(1, 2, 3, 4, 5, 6))

        val (tickets, balance) = lottoStore.exchange(seedMoney, numbers)
        assertEquals(1, tickets.size)
        assertThat(tickets[0].numbers.numbers).hasSameElementsAs(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber.of(it) })
        assertEquals(0, balance)
    }

    @DisplayName("구입 금액보다 더 많은 로또 티켓을 교환할 수 없다.")
    @Test
    fun shouldFailExchangeMoreThanMoney() {
        val lottoPrice = 1000
        val lottoStore = LottoStore(lottoTicketPrice = lottoPrice, lottoTicketMachine = LottoTicketMachine())

        val seedMoney = 1000
        val numbers = listOf(
            LottoNumbers.of(1, 2, 3, 4, 5, 6),
            LottoNumbers.of(1, 2, 3, 4, 5, 6),
        )

        assertThrows<IllegalArgumentException> {
            lottoStore.exchange(seedMoney, numbers)
        }
    }
}
