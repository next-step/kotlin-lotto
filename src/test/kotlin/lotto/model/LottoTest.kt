package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoTest {
    @DisplayName(value = "input으로 받은 string에서 로또 조건을 만족하는지 확인한다")
    @Test
    fun checkLottoRule() {
        assertThatThrownBy { Lotto.make("1,2,3,4,5") }.isInstanceOf(IllegalArgumentException::class.java)
        assertThatThrownBy { Lotto.make("1.2.3.4.5") }.isInstanceOf(IllegalArgumentException::class.java)
        assertThatThrownBy { Lotto.make("1,2,3,4,5,66") }.isInstanceOf(IllegalArgumentException::class.java)
        assertThatThrownBy { Lotto.make("1,2,3,4,5,5") }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @DisplayName(value = "보유한 로또와 당첨로또를 비교하여 일치하는 숫자의 개수를 반환한다.")
    @Test
    fun validLottoCheck() {
        val lotto = Lotto.make("1,2,3,4,5,6")

        val win = lotto.checkWin(
            WinnerLotto(
                Lotto.make("1,2,3,4,5,10"), LottoNo.from(6)
            )
        )
        assertThat(win).isEqualTo(Win.SECOND)
    }
}
