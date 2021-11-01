package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WinningLottoInformationTest {

    @Test
    fun `당청 로또 정보를 생성할 수 있다`() {
        val lottoNumbers = (1..6).map { LottoNumber.valueOf(it) }
        val bonusNumber = LottoNumber.valueOf(7)
        val winningLotto = Lotto(lottoNumbers)

        val actual = WinningLottoInformation(winningLotto, bonusNumber)

        assertThat(actual).isNotNull
    }
}
