package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import lotto.domain.enums.LottoRank

class LottoMatchReportTest : FunSpec({

    test("로또 순위에 따라 수익률을 계산한다.") {
        forAll(
            row(LottoRank.FIRST, 2_000_000.0),
            row(LottoRank.SECOND, 30_000.0),
            row(LottoRank.THIRD, 1_500.0),
            row(LottoRank.FOURTH, 50.0),
            row(LottoRank.FIFTH, 5.0),
            row(LottoRank.NONE, 0.0)
        ) {
            lottoRank: LottoRank, rateOfReturn: Double ->
            LottoMatchReport.of(listOf(lottoRank)).rateOfReturn shouldBe rateOfReturn
        }
    }

    test("로또 순위에 따라 총 로또의 수익률을 계산한다.") {
        forAll(
            row(LottoRank.FIRST, 500000.0),
            row(LottoRank.SECOND, 7500.0),
            row(LottoRank.THIRD, 375.0),
            row(LottoRank.FOURTH, 12.5),
            row(LottoRank.FIFTH, 1.25),
            row(LottoRank.NONE, 0.0)
        ) {
            lottoRank: LottoRank, rateOfReturn: Double ->
            LottoMatchReport.of(
                listOf(
                    LottoRank.NONE,
                    LottoRank.NONE,
                    LottoRank.NONE,
                    lottoRank
                )
            ).rateOfReturn shouldBe rateOfReturn
        }
    }

    test("로또 순위별 카운팅이 가능하다.") {
        val report = LottoMatchReport.of(
            listOf(
                LottoRank.FIRST,
                LottoRank.SECOND,
                LottoRank.SECOND,
                LottoRank.THIRD,
                LottoRank.THIRD,
                LottoRank.THIRD,
                LottoRank.FOURTH
            )
        )
        report.matchingCountBy(LottoRank.FIRST) shouldBe 1
        report.matchingCountBy(LottoRank.SECOND) shouldBe 2
        report.matchingCountBy(LottoRank.THIRD) shouldBe 3
        report.matchingCountBy(LottoRank.FOURTH) shouldBe 1
        report.matchingCountBy(LottoRank.FIFTH) shouldBe 0
    }
})
