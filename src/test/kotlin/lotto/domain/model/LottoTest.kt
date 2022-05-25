package lotto.domain.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTest {
    @Test
    fun `Lotto는 발급받은 로또의 번호들을 보관한다`() {
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 6)
        val lotto = Lotto(lottoNumbers)

        assertThat(lotto.numbers).isEqualTo(lottoNumbers)
    }
}
