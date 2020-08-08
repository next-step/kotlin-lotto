package lotto.domain

import lotto.LottoUtils.luckyNumbers
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

class BonusNumberTest {

    @ParameterizedTest
    @ValueSource(ints = [0, 46])
    fun `numbers bound`(number: Int) {
        Assertions.assertThatThrownBy {
            // given
            luckyNumbers = LuckyNumbers(listOf(1, 2, 3, 4, 5, 6))

            // when
            BonusNumber(number)

            // then
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Bonus number is out of Bounds : $number")
    }

    @Test
    fun `number duplication`() {
        Assertions.assertThatThrownBy {
            // given
            luckyNumbers = LuckyNumbers(listOf(1, 2, 3, 4, 5, 6))

            // when
            BonusNumber(1)

            // then
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Duplication between lucky numbers and bonus number : 1")
    }
}
