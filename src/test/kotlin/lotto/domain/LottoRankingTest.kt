package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import lotto.domain.LottoRanking.*

class LottoRankingTest : StringSpec({
    "로또 번호 일치 수로 LottoRanking 가져온다." {
        forAll(
            row(3, true, FIFTH),
            row(4, true, FOURTH),
            row(5, false, THIRD),
            row(5, true, SECOND),
            row(6, false, FIRST)
        ) { number, matchedBonusBall, ranking ->
            val lottoRanking = LottoRanking.lottoRanking(number, matchedBonusBall)
            lottoRanking shouldBe ranking
        }
    }
})
