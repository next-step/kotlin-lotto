package lotto.domain.vender

import lotto.domain.value.Price
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class LottoTicketVendorTest {

    @ParameterizedTest
    @CsvSource(value = ["1000,1", "2000,2"])
    fun `1000원에 1장씩 로또 티켓을 구매할수 있다`(price: Long, expect: Int) {
        //given
        val vendor = LottoTicketVendor()

        //when
        val tickets = vendor.buyAutomaticTicket(Price(price))

        //then
        assertThat(tickets).hasSize(expect)
    }
}
