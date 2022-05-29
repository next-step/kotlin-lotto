package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

class LottoGameTest {
    private lateinit var lottoGame: LottoGame

    @BeforeEach
    fun beforeEachTest() {
        lottoGame = LottoGame()
    }

    @ParameterizedTest
    @CsvSource(value = ["14000|14", "1000|1", "2000|2"], delimiter = '|')
    fun `로또 구입 금액에 해당하는 로또 수를 계산할 수 있다`(money: Long, expected: Int) {
        assertThat(lottoGame.generateLotto(money).size).isEqualTo(expected)
    }

    @ParameterizedTest
    @ValueSource(strings = ["900", "0"])
    fun `로또 구입 금액이 1천원 미만이면 IllegalArgumentException 예외가 발생한다`(money: Long) {
        assertThrows(IllegalArgumentException::class.java) {
            lottoGame.generateLotto(money)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1900", "2001"])
    fun `로또 구입 금액이 1천원 이상인데, 천단위가 아니면 IllegalArgumentException 예외가 발생한다`(money: Long) {
        assertThrows(IllegalArgumentException::class.java) {
            lottoGame.generateLotto(money)
        }
    }
}
