package lotto.domain

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

class LottoNumbersTest {

    @Test
    fun `numbers size`() {
        assertThatThrownBy {
            // when
            LottoNumbers(listOf(1, 2, 3, 4))

            // then
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Invalid lotto numbers size : 4")
    }

    @Test
    fun `numbers duplication`() {
        assertThatThrownBy {
            // when
            LottoNumbers(listOf(1, 1, 3, 4, 5, 6))

            // then
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("There is duplication in Lotto numbers : [1, 3, 4, 5, 6]")
    }

    @Test
    fun `match up`() {
        assertTrue(LottoNumbers(listOf(1, 2, 3, 4, 5, 6)).isMatchedUp(luckyNumber = 1))
        assertFalse(LottoNumbers(listOf(1, 2, 3, 4, 5, 6)).isMatchedUp(luckyNumber = 7))
    }
}
