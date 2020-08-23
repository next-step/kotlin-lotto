package lotto.model.lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class TicketsTest {

    private val defaultNumbers = "1,2,3,4,5,6".toNumbers()

    @DisplayName(value = "Tickets의 size와, 생성된 로또의 갯수는 같아야한다.")
    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4])
    fun checkTicketsToLottos(inputNumbersSize: Int) {
        val list = mutableListOf<Numbers>().apply {
            repeat(inputNumbersSize) {
                add(defaultNumbers)
            }
        }

        val tickets = Tickets(list)
        assertThat(tickets.toLottos().size).isEqualTo(list.size)
    }
}
