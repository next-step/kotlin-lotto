package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class LottoTest {
    @Test
    fun `로또 번호는 6개다`() {
        repeat(5) {
            Assertions.assertThat(Lotto.create().size).isEqualTo(6)
        }
    }

    @Test
    fun `로또 번호는 각각 1 이상 45 이하이다`() {
        repeat(5) {
            Assertions.assertThat(Lotto.create()).allMatch { number -> number in 1..45 }
        }
    }

    @Test
    fun `로또 번호는 정렬되어 있다`() {
        repeat(5) {
            val lottoNumbers = Lotto.create()
            Assertions.assertThat(lottoNumbers).isEqualTo(lottoNumbers.sorted())
        }
    }
}
