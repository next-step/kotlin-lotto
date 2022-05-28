package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottosTest {

    @Test
    fun `로또객체생성`() {
        val lottoNumbers = listOf(
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(1),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(6)
        )

        val lotto = Lotto(lottoNumbers)

        val lottos = Lottos(listOf(lotto))

        assertThat(lottos.lottos.size).isEqualTo(1)
    }
}
