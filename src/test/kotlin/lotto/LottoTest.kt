package lotto

import lotto.domain.Lotto
import lotto.domain.LottoNumbers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTest {
    @Test
    fun `로또 생성 테스트`() {
        val lotto = Lotto({ LottoNumbers.of(listOf(1, 2, 3, 4, 7, 8)) })
        assertThat(lotto.numbers.lottoNumbers.map { it.number })
            .containsExactlyInAnyOrder(1, 2, 3, 4, 7, 8)
    }
}
