package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottosTest {

    @Test
    fun `LottoRank 를 구하는데 성공한다`() {
        // given
        val lottoNumbers = LottoNumbers(
            setOf(
                LottoNumber(1), LottoNumber(2), LottoNumber(3), LottoNumber(4),
                LottoNumber(5), LottoNumber(6)
            )
        )
        val lottos = Lottos.of(1, FakeLottoNumberGenerator())

        // when
        val lottoResult = lottos.getLottoResult(lottoNumbers)

        // then
        assertThat(lottoResult.getRankCount(LottoRank.FIRST)).isEqualTo(1)
    }
}
