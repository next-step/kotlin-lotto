package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinningLottoTest {
    @Test
    fun `당첨 번호는 로또 번호와 보너스 번호로 이루어져 있다`() {

        val lottoNumbers = setOf(
            LottoNumber.get(1),
            LottoNumber.get(2),
            LottoNumber.get(3),
            LottoNumber.get(4),
            LottoNumber.get(5),
            LottoNumber.get(6)
        )

        val bonusNumber = LottoNumber.get(8)

        assertThat(WinningLotto(lottoNumbers, bonusNumber)).isNotNull
    }
}
