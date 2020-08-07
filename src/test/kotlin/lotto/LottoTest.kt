package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoTest {
    @Test
    @DisplayName("test input money")
    fun inputtest() {
        assertThat(InputNumber().buy(14000)).isEqualTo(14000)
    }

    @Test
    @DisplayName("Ticket")
    fun ticketstest() {
        assertThat(Lotto().buytickets(14000)).isEqualTo(14)
    }

    @Test
    @DisplayName("ticket size check")
    fun ticketsizecheck() {
        assertThat(Lotto().tickets(14)).isEqualTo(14)
    }
}
