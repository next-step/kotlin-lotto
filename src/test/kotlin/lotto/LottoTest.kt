package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoTest {
    @Test
    @DisplayName("test input money")
    fun inputTest() {
        assertThat(InputNumber().buy(14000)).isEqualTo(14000)
    }

    @Test
    @DisplayName("Ticket")
    fun ticketsTest() {
        assertThat(Lotto().buyTickets(14000)).isEqualTo(14)
    }

    @Test
    @DisplayName("ticket size check")
    fun ticketSizeCheck() {
        assertThat(Lotto().tickets(14).size).isEqualTo(14)
    }

    @Test
    @DisplayName("check match")

    fun testMatch() {
        val userLotto = arrayOf(1, 2, 3, 4)
        val winningLotto = arrayOf(1, 2, 3, 4)
        assertThat(Lotto().match(userLotto, winningLotto)).isEqualTo(4)
    }
}
