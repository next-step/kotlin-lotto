package lotto.domain

import org.junit.jupiter.api.assertDoesNotThrow

class LottosTest {

    fun `n개 `() {
        // given
        val lottoNumbers =
            listOf(LottoNumber(1), LottoNumber(2), LottoNumber(3), LottoNumber(4), LottoNumber(5), LottoNumber(6))
        val lotto = Lotto(lottoNumbers)
        val lottos = Lottos(lottos = listOf(lotto))

        // expect
        assertDoesNotThrow { lottos.getLottoResult(lottoNumbers) }
    }
}
