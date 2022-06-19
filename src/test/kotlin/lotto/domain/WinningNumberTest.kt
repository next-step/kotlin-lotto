package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class WinningNumberTest {
    @ParameterizedTest
    @CsvSource(value = ["3,true", "10, false"])
    fun `로또 번호가 당첨 번호와 일치하는지 알 수 있다`(lottoNumber: Int, isWinningNumber: Boolean) {
        // given
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        // when
        val result = WinningNumber(winningNumbers).hasNumber(lottoNumber)
        // then
        assertEquals(isWinningNumber, result)
    }
}
