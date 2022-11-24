package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class LottoGameTest {

    @Test
    @DisplayName("로또 게임 실행 시 로또 6자리번호 생성")
    fun `Create a 6-digit Lotto number when playing Lotto Game`() {
        val lotto = LottoGame.start(AutoLotto)

        assertThat(lotto.numbers.size).isEqualTo(6)
    }

    @Test
    @DisplayName("로또 번호 1,2,3,4,5,6와 당첨번호 1,2,3,7,8,9일 경우 4등")
    fun `If lotto numbers 1,2,3,4,5,6 and winning numbers 1,2,3,7,8,9 are 4th place`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winnerLotto = Lotto(listOf(1, 2, 3, 7, 8, 9))

        val result = LottoGame.getResultOfGame(lotto, winnerLotto)

        assertThat(result).isEqualTo(LottoGameResult.FOUR)
    }
}
