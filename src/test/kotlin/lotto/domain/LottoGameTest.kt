package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoGameTest {
    @ParameterizedTest
    @CsvSource(value = ["14000|14", "1000|1", "2500|2"], delimiter = '|')
    fun `로또 구입 금액에 해당하는 로또 수를 계산할 수 있다`(money: Long, expected: Long) {
        val sut = LottoGame()
        val actual = sut.getNumOfLotto(money)
        assertEquals(expected, actual)
    }
}
