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
                            LottoNumber.of(1),
                            LottoNumber.of(2),
                            LottoNumber.of(3),
                            LottoNumber.of(4),
                            LottoNumber.of(5),
                            LottoNumber.of(6)
                        )
                    )
                )
            ),
            WinningLotto(
                Lotto(
                    listOf(
                        LottoNumber.of(1),
                        LottoNumber.of(2),
                        LottoNumber.of(3),
                        LottoNumber.of(4),
                        LottoNumber.of(5),
                        LottoNumber.of(6)
                    )
                ),
                LottoNumber.of(7)
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
