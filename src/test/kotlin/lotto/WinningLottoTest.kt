package lotto

import lotto.domain.WinningLotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class WinningLottoTest {

    @ParameterizedTest
    @ValueSource(strings = ["1, 3, 10, 11, 43, 32", "2, 3, 4, 10, 15, 41"])
    fun `로또 번호를 올바르게 입력 한다`(lottoNumber: String) {
        val winningLotto = WinningLotto(lottoNumber)
        assertThat(winningLotto.getWinningLottoNumberList().size).isEqualTo(6)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1, 3 ,10, 11, 41", "1, 3"])
    fun `로또 번호가 6개가 아닐경우 IllegalArgumentException 예외가 발생한다`(lottoNumber: String) {
        assertThrows<IllegalArgumentException> { WinningLotto(lottoNumber) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1, 3, 10, 20 , 43, 45", "1, 32, 38, 41, 44, 50"])
    fun `로또 번호 범위를 초과 했을 경우 IllegalArgumentException 예외가 발생한다`(lottoNumber: String) {
        assertThrows<IllegalArgumentException> { WinningLotto(lottoNumber) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1, 1, 45, 32, 31, 22"])
    fun `로또 번호가 중복되었다면 개수가 부족하여 IllegalArgumentException 예외가 발생한다`(lottoNumber: String) {
        assertThrows<IllegalArgumentException> { WinningLotto(lottoNumber) }
    }
}
