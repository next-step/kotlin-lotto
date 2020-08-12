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
        assertThat(Lotto().buyTickets(14000)).isEqualTo(14)
    }

    @Test
    @DisplayName("ticket size check")
    fun ticketSizeCheck() {
        assertThat(Lotto().tickets(14).size).isEqualTo(14)
    }

    @Test
    @DisplayName("count lottonumber match")
    fun `count`() {
        val winningNumber = listOf(1, 2, 3, 14, 15, 16)
        val userNumber = listOf(1, 2, 3, 4, 5, 6)
        assertThat(Lotto().match(userNumber, winningNumber)).isEqualTo(3)
    }

    @Test
    @DisplayName("Prize")
    fun `prize`() {
        assertThat(Lotto().result(5)).isEqualTo(Rank.FIVEMATCH)
    }
}

