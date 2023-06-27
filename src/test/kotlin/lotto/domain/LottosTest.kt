package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottosTest {

    @Test
    fun `LottoRank 를 구하는데 성공한다`() {
        // given
        val lottoNumbers = (1..6).map { LottoNumber(it) }

        val lottos = Lottos.of(1, FakeLottoNumberGenerator())
        val lottoMatchNumbers = LottoMatchNumbers.of(lottoNumbers.map { it.number }, 7)

        // when
        val lottoResult = lottos.getLottoResult(lottoMatchNumbers)

        // then
        assertThat(lottoResult.getRankCount(LottoRank.FIRST)).isEqualTo(1)
    }
}
