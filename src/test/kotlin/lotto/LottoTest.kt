package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoTest {
    @Test
    @DisplayName("test input money")
    fun inputTest() {
        assertThat(InputNumber.buy()).isEqualTo(14000)
    }

    @Test
    @DisplayName("Ticket")
    fun ticketsTest() {
        assertThat(Ticket().buyTickets(14000)).isEqualTo(14)
    }

    @Test
    @DisplayName("Check to change Prize")
    fun prize() {
        assertThat(Rank.findMatchCount(5)).isEqualTo(Rank.FIVEMATCH)
    }
/*
    @Test
    @DisplayName("당첨 확인")
    private var  ticket =  Ticket()
    fun fiveThousandDollar(){
        assertThat()
    }
*/
}
