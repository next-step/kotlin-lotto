package lotto.domain

import lotto.domain.lotto.LottoNumber
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class LottoGameTest {

    @Test
    @DisplayName("로또 게임 실행 시 로또 6자리번호 생성")
    fun `Create a 6-digit Lotto number when playing Lotto Game`() {
        val lotto = LottoGame.pick(1, AutoLotto)
        assertThat(lotto.first().numbers.size).isEqualTo(6)
    }

    @Test
    @DisplayName("로또 번호가 1,2,3,4,5,6면서 당첨번호가 1,2,3,7,8,9 보너스 번호가 10일 경우 5등")
    fun `Lotto number is 1,2,3,4,5,6 and the winning number is 1,2,3,7,8,9 bonus number is 10, 5th place`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) })
        val winnerLotto = Lotto(listOf(1, 2, 3, 7, 8, 9).map { LottoNumber(it) })
        val bonusNumber = LottoNumber(10)

        val result = LottoGame.getResultOfGames(arrayListOf(lotto), winnerLotto, bonusNumber)

        assertThat(result.first()).isEqualTo(LottoGameResult.FIFTH)
    }

    @Test
    @DisplayName("로또 번호가 1,2,3,4,5,6면서 당첨번호가 1,2,3,4,5,9 보너스 번호가 6일 경우 2등")
    fun `Lotto number 1,2,3,4,5,6 and winning number 1,2,3,4,5,9 bonus, If the winning number is 6, second place`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) })
        val winnerLotto = Lotto(listOf(1, 2, 3, 4, 5, 9).map { LottoNumber(it) })
        val bonusNumber = LottoNumber(6)

        val result = LottoGame.getResultOfGames(arrayListOf(lotto), winnerLotto, bonusNumber)

        assertThat(result.first()).isEqualTo(LottoGameResult.SECOND)
    }

    @Test
    @DisplayName("로또 번호가 1,2,3,4,5,6면서 당첨번호가 1,2,3,4,5,9 보너스 번호가 6일 경우 2등")
    fun `Lotto number 1,2,3,4,5,6 and winning number 1,2,3,4,5,9 bonus, If the winning number is 6, second 1place`() {
        val numberOfAuto = LottoGame.calculateNumberOfAutoGames(10, 2)
        assertThat(numberOfAuto).isEqualTo(8)
    }
}
