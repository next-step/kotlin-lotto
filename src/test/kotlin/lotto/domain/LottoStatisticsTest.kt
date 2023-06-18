package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoStatisticsTest : StringSpec({
    val lottoStatistics = LottoStatistics()

    "총 수익률을 계산한다." {
        val lottos = Lottos(
            mutableListOf(
                LottoNumbers(
                    listOf(
                        LottoNumber(1),
                        LottoNumber(2),
                        LottoNumber(3),
                        LottoNumber(4),
                        LottoNumber(5),
                        LottoNumber(6)
                    )
                ),
                LottoNumbers(
                    listOf(
                        LottoNumber(11),
                        LottoNumber(12),
                        LottoNumber(13),
                        LottoNumber(14),
                        LottoNumber(15),
                        LottoNumber(16)
                    )
                ),
                LottoNumbers(
                    listOf(
                        LottoNumber(21),
                        LottoNumber(22),
                        LottoNumber(23),
                        LottoNumber(24),
                        LottoNumber(25),
                        LottoNumber(26)
                    )
                )
            )
        )

        val winnerNumbers = listOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(6)
        )

        val result = lottoStatistics.analyze(lottos, winnerNumbers)
        val profitRate = lottoStatistics.getProfitRate(Payment(14000), result)
        profitRate shouldBe 2000000000 / 14000
    }
})
