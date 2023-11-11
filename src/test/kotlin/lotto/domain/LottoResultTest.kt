package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoResultTest {
    @Test
    fun `사용자의 로또와 당첨로또가 완전히 동일하면 1등이다`() {
        val userLotto = Lotto(
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6)
            )
        )
        val winningLotto = Lotto(
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6)
            )
        )
        val lottoResult = LottoResult(listOf(userLotto), winningLotto)
        assertThat(lottoResult.getLottosOfRank(LottoRank.FIRST)).isNotNull
        assertThat(lottoResult.getLottosOfRank(LottoRank.FIRST)).contains(userLotto)
    }
}
