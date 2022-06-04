package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottosTest {

    @Test
    fun `1에서 45 사이의 숫자가의 로또 객체들을 생성`() {
        val lottoNumbers = setOf(
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

    @Test
    fun `로또 값이 없을 경우 빈 리스트를 반환`() {
        val lottos = Lottos()
        assertThat(lottos.lottos).isEmpty()
    }
}
