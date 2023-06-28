package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import lotto.domain.LottoRanking.FIFTH
import lotto.domain.LottoRanking.FIRST
import lotto.domain.LottoRanking.FOURTH
import lotto.domain.LottoRanking.THIRD

class LottoRankingTest : StringSpec({
    "로또 번호 일치 수로 LottoRanking 가져온다." {
        forAll(
            row(3, FIFTH),
            row(4, FOURTH),
            row(5, THIRD),
            row(6, FIRST)
        ) { number, ranking ->
            val lottoRanking = LottoRanking.lottoRanking(number)
            lottoRanking shouldBe ranking
        }
    }
})
