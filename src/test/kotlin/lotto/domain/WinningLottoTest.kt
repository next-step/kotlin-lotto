package lotto.domain

import lotto.fixture.lottoNumber
import lotto.fixture.winningLotto
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class WinningLottoTest {
    @ParameterizedTest
    @CsvSource(value = ["3,true", "10, false"])
    fun `로또 번호가 당첨 번호와 일치하는지 알 수 있다`(number: Int, isWinningNumber: Boolean) {
        // given
        val lottoNumber = lottoNumber(number)
        val winningNumbers = winningLotto(1, 2, 3, 4, 5, 6)
        // when
        val result = winningNumbers.hasNumber(lottoNumber)
        // then
        assertEquals(isWinningNumber, result)
    }
}
