package specific.lotto.domain

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class TicketTest {
    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,4,5,5"])
    fun `로또 번호들은 중복을 허용하지 않는다`(input: String) {
        // given
        val numbers = input.split(",").map { it.toInt() }.map(::Number).toSet()

        // when, then
        assertThrows<IllegalArgumentException> { Ticket(numbers) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,4,5", "1,2,3,4,5,6,7"])
    fun `로또 번호들은 총 6개다`(input: String) {
        // given
        val numbers = input.split(",").map { it.toInt() }.map(::Number).toSet()

        // when, then
        assertThrows<IllegalArgumentException> { Ticket(numbers) }
    }
}
