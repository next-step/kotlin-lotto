package specific.lotto.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class WinningSetTest {
    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,4,5,5"])
    fun `당첨 번호들은 중복되면 안된다`(input: String) {
        // given
        val numbers = input.split(",").map { it.toInt() }.map { Number(it) }.toSet()

        // when, then
        org.junit.jupiter.api.assertThrows<IllegalArgumentException> { WinningSet(numbers) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,4,5", "1,2,3,4,5,6,7"])
    fun `당첨 번호들은 총 6개다`(input: String) {
        // given
        val numbers = input.split(",").map { it.toInt() }.map { Number(it) }.toSet()

        // when, then
        org.junit.jupiter.api.assertThrows<IllegalArgumentException> { WinningSet(numbers) }
    }
}
