package lotto

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class WinningLottoTest {
    @Test
    fun `지난 주 당첨 번호와 몇 개가 일치하는지 확인할 수 있다`() {
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }
        Assertions.assertThat(Lotto(lottoNumbers).checkEqualCount(Lotto(lottoNumbers))).isEqualTo(6)
    }
}
