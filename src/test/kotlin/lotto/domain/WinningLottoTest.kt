package lotto.domain

import WinningLotto
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class WinningLottoTest {

    @Test
    fun `당첨 번호와 보너스 번호가 중복되면 예외를 발생시킨다`() {
        val lottoNumbers = listOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(6),
        )

        val bonusNumber = LottoNumber(6)

        assertThatThrownBy { WinningLotto(lottoNumbers, bonusNumber) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("보너스 번호는 당첨 번호와 중복되면 안됩니다. bonusNumber = $bonusNumber")
    }
}
