package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class LottoTest {
    private val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

    @DisplayName("당첨번호와 비교해서 일치하는 숫자의 갯수를 반환한다.")
    @Test
    fun matchLotto() {
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 9, 8, 7))
        assertThat(lotto.matchLotto(winningNumbers)).isEqualTo(3)
    }

    @DisplayName("로또번호와 보너스볼이 일치하면 true, 일치하지 않으면 false를 반환한다.")
    @Test
    fun matchBonusBall() {
        assertAll(
            { assertThat(lotto.matchBonusBall(6)).isTrue() },
            { assertThat(lotto.matchBonusBall(7)).isFalse() }
        )
    }
}
