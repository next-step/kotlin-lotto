package lotto.view

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

class InputTests {
    @ParameterizedTest
    @ValueSource(ints = [100, 200, 300, 400, 900, 999])
    fun `금액이 1000 보다 작으면 Exception이 발생해야 한다`(amount: Int) {
        assertThrows<IllegalArgumentException> { Input(amount) }
    }

    @ParameterizedTest
    @ValueSource(ints = [1000, 2000, 3000, 4000])
    fun `금액이 1000 보다 크면은 Exception은 발생을 안한다`(amount: Int) {
        assertDoesNotThrow { Input(amount) }
    }

    @ParameterizedTest
    @CsvSource(value = ["1000,1", "1500,1", "2000,2", "2999, 2"])
    fun `1천원당 1장이 구매가 가능하다`(amount: Int, exceptedCount: Int) {
        val input = Input(amount)

        assertThat(input.lottoCount)
            .isEqualTo(exceptedCount)
    }
}
