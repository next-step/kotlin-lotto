package specific.lotto.domain

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import specific.study.Delimiter.Companion.split

class TicketTest {
    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,4,5,5"])
    fun `로또 번호들은 중복되면 안된다`(input: String) {
        // given
        val numbers = input.split(",").map { it.toInt() }.map { Number(it) }.toSet()

        // when, then
        assertThrows<IllegalArgumentException> { Ticket(numbers) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,4,5", "1,2,3,4,5,6,7"])
    fun `로또 번호들은 총 6개다`(input: String) {
        // given
        val numbers = input.split(",").map { it.toInt() }.map { Number(it) }.toSet()

        // when, then
        assertThrows<IllegalArgumentException> { Ticket(numbers) }
    }
}
