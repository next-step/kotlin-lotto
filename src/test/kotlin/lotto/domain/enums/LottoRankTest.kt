package lotto.domain.enums

import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class LottoRankTest : FunSpec({

    test("매칭 결과와 보너스 번호 매칭 여부에 따라 로또 순위가 결정된다.") {
        forAll(
            row(6, false, LottoRank.FIRST),
            row(5, false, LottoRank.THIRD),
            row(4, false, LottoRank.FOURTH),
            row(3, false, LottoRank.FIFTH),
            row(2, false, LottoRank.NONE),
            row(1, false, LottoRank.NONE),
            row(0, false, LottoRank.NONE),

            row(6, true, LottoRank.FIRST),
            row(5, true, LottoRank.SECOND),
            row(4, true, LottoRank.FOURTH),
            row(3, true, LottoRank.FIFTH),
            row(2, true, LottoRank.NONE),
            row(1, true, LottoRank.NONE),
            row(0, true, LottoRank.NONE)
        ) {
            matchingCount: Int, isMatchBonusNumber: Boolean, lottoRank: LottoRank ->
            LottoRank.of(matchingCount, isMatchBonusNumber) shouldBe lottoRank
        }
    }
})
