package lotto

import lotto.domain.Lotto
import lotto.domain.LottoNumbers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTest {
    @Test
    fun `로또 생성 테스트`() {
        val lotto = Lotto({ LottoNumbers.of(listOf(1, 2, 3, 4, 7)) })
        assertThat(lotto.numbers.lottoNumbers[0].number).isEqualTo(1)
        assertThat(lotto.numbers.lottoNumbers[1].number).isEqualTo(2)
        assertThat(lotto.numbers.lottoNumbers[2].number).isEqualTo(3)
        assertThat(lotto.numbers.lottoNumbers[3].number).isEqualTo(4)
        assertThat(lotto.numbers.lottoNumbers[4].number).isEqualTo(7)
    }
}
