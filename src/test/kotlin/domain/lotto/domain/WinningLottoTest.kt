package domain.lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

@DisplayName("당첨 로또(WinningLotto)")
class WinningLottoTest {

    @Test
    fun `로또 당첨 번호와 보너스 번호를 통해 생성할 수 있다`() {
        val lottoString = "1, 2, 3, 4, 5, 6"
        val bonusBall = 7
        val winningLotto = WinningLotto.from(lottoString, bonusBall) { it.split(", ")}

        assertAll(
            { assertThat(winningLotto).isNotNull },
            { assertThat(winningLotto).isExactlyInstanceOf(WinningLotto::class.java) },
        )
    }

}