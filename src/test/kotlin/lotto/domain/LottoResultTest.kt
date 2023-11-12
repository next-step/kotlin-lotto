package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoResultTest {
    @Test
    fun `로또 결과를 생성한다`() {
        val lottoResult = LottoResult(
            LottoMoney(1000),
            Lottos(
                listOf(
                    Lotto(
                        listOf(
                            LottoNumber(1),
                            LottoNumber(2),
                            LottoNumber(3),
                            LottoNumber(4),
                            LottoNumber(5),
                            LottoNumber(6)
                        )
                    )
                )
            ),
            WinningLotto(
                Lotto(
                    listOf(
                        LottoNumber(1),
                        LottoNumber(2),
                        LottoNumber(3),
                        LottoNumber(4),
                        LottoNumber(5),
                        LottoNumber(6)
                    )
                )
            )
        )
        assertThat(lottoResult.getLottoResult().lottoRanks).isEqualTo(
            mapOf(
                LottoRank.FIRST to 1
            )
        )
        assertThat(lottoResult.getLottoResult().earningRate).isEqualTo(2000000.0)
    }
}
