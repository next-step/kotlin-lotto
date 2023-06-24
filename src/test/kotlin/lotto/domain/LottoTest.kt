package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTest {

    @Test
    fun `로또 번호 매칭에 성공한다`() {
        // given
        val lottoNumbers = FakeLottoNumberGenerator().generate().let { LottoNumbers.of(it) }

        val lotto = Lotto(FakeLottoNumberGenerator())

        // when
        val lottoRank = lotto.matchLottoNumber(lottoNumbers)

        // then
        assertThat(lottoRank).isEqualTo(LottoRank.FIRST)
    }
}
