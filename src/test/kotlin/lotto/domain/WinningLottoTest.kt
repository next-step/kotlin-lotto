package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class WinningLottoTest {

    @DisplayName("Winning Lotto 유효성 확인, 보너스 번호는 당첨번호에 포함 안되어야함, 에러")
    @Test
    fun validateWinningLottoError() {
        val prizeLotto = Lotto.from("1,2,3,4,5,6")
        val bonusNumber = LottoNumber.from("5")

        assertThatThrownBy { WinningLotto(prizeLotto!!, bonusNumber) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @DisplayName("Winning Lotto 유효성 확인, 보너스 번호는 당첨번호에 포함 안되어야함 ")
    @Test
    fun validateWinningLotto() {
        val prizeLotto = Lotto.from("1,2,3,4,5,6")
        val bonusNumber = LottoNumber.from("7")

        assertThat(WinningLotto(prizeLotto!!, bonusNumber))
            .isNotInstanceOfAny(Exception::class.java)
    }
}
