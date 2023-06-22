package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test

class LottoTest {

    @Test
    fun `lottoNumbers 가 6개가 아닌 경우 생성에 실패한다`() {
        // expect
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            Lotto(setOf(LottoNumber(1)))
        }
    }

    @Test
    fun `로또 번호 매칭에 성공한다`() {
        // given
        val lottoNumbers = listOf(
            LottoNumber(1), LottoNumber(2), LottoNumber(3), LottoNumber(4),
            LottoNumber(5), LottoNumber(6)
        )

        val lotto = Lotto(lottoNumbers.toSet())

        // when
        val lottoRank = lotto.matchLottoNumber(lottoNumbers)

        // then
        assertThat(lottoRank).isEqualTo(LottoRank.MATCH_SIX)
    }
}
