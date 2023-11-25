package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class WinningLottoTest {
    @Test
    fun `보너스 볼 번호는 지난주 당첨번호에 포함되지 않는 번호이다`() {
        val bonusNumber = 6
        val winningNumbers = Lotto(1, 2, 3, 4, 5, 6)

        Assertions.assertThatThrownBy {
            WinningLotto(winningNumbers, LottoNumber(bonusNumber))
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("보너스 번호는 당첨 번호와 중복되지 않아야 합니다.")
    }
}
