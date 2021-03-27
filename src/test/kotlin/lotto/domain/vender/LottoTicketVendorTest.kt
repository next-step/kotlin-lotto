package lotto.domain.vender

import lotto.domain.ticket.LottoTicketCreateDto
import lotto.domain.value.Price
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class LottoTicketVendorTest {

    @ParameterizedTest
    @CsvSource(value = ["1000,1", "2000,2"])
    fun `1000원에 1장씩 자동 로또 티켓을 구매할수 있다`(price: Long, expect: Int) {
        // given
        val dto = LottoTicketCreateDto(
            price = Price(price),
            manualAmount = 0,
            manualRequest = emptyList()
        )
        val vendor = LottoTicketVendor(dto)

        // when
        val tickets = vendor.buyTickets()

        // then
        assertThat(tickets).hasSize(expect)
    }

    @Test
    fun `수동 로또를 구매한다`() {
        // given
        val dto = LottoTicketCreateDto(
            price = Price(2000),
            manualAmount = 2,
            manualRequest = listOf(
                "1,2,3,4,5,6",
                "2,3,4,5,6,7"
            )
        )
        val vendor = LottoTicketVendor(dto)

        // when
        val tickets = vendor.buyTickets()

        // then
        assertThat(tickets).hasSize(2)
    }
}
