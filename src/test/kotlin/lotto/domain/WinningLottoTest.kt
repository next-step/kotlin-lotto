package lotto.domain

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class WinningLottoTest {
    @Test
    fun check_bonus_ball_same_correct_numbers() {
        val numbers = setOf(1, 2, 3, 4, 5, 6)
        val correctLotto = Lotto(numbers)
        assertThatThrownBy {
            WinningLotto(correctLotto, Number.getNumber(3))
        }.isInstanceOf(IllegalArgumentException::class.java).hasMessageContaining("보너스 번호는 당첨번호와 같으면 안됩니다.")
    }
}
