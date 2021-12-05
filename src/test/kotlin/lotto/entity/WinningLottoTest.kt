package lotto.entity

import lotto.domain.entity.winning.WinningLotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class WinningLottoTest {

    @ParameterizedTest
    @ValueSource(strings = ["1,2", "1,11,22,33,35,37,41,42"])
    fun `생성된 당첨 로또 번호가(6개)가 아닐 경우 IllegalArgumentException 예외가 발생한다`(winningLottoNumber: String) {
        assertThrows<IllegalArgumentException> {
            WinningLotto(
                winningLottoNumber
                    .split(",")
                    .map { it.trim().toInt() }
                    .sorted()
                    .toList()
            )
        }
    }

    @ParameterizedTest
    @CsvSource(value = ["1,3,11,25,41,45|41"], delimiterString = "|")
    fun `당첨 로또 번호에 특정 번호가 존재하는지 확인합니다`(winningLottoNumber: String, targetNumber: Int) {
        val winningLotto = convertWinningLotto(winningLottoNumber)
        assertThat(winningLotto.containsLottoNumber(targetNumber)).isTrue
    }

    @ParameterizedTest
    @CsvSource(value = ["11,24,33,35,41,43|1"], delimiterString = "|")
    fun `당첨 로또 번호에 특정 번호가 존재하지 않는것을 확인 합니다`(winningLottoNumber: String, targetNumber: Int) {
        val winningLotto = convertWinningLotto(winningLottoNumber)
        assertThat(winningLotto.containsLottoNumber(targetNumber)).isFalse
    }

    private fun convertWinningLotto(winningLottoNumber: String) : WinningLotto =
        WinningLotto(
            winningLottoNumber
                .split(",")
                .map { it.trim().toInt() }
                .sorted()
                .toList()
        )

}
