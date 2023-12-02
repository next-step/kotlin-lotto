package lotto2.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoRankingTest : StringSpec({

    "6개 일치하면 FIRST 등급을 반환한다" {
        LottoRanking.valueOf(6) shouldBe LottoRanking.FIRST
    }

    "5개 일치하고 보너스 번호가 맞으면 SECOND 등급을 반환한다" {
        LottoRanking.valueOf(5, isBonusMatched = true) shouldBe LottoRanking.SECOND
    }

    "5개 일치하고 보너스 번호가 틀리면 THIRD 등급을 반환한다" {
        LottoRanking.valueOf(5) shouldBe LottoRanking.THIRD
    }

    "4개 일치하면 FOURTH 등급을 반환한다" {
        LottoRanking.valueOf(4) shouldBe LottoRanking.FOURTH
    }

    "3개 일치하면 FIFTH 등급을 반환한다" {
        LottoRanking.valueOf(3) shouldBe LottoRanking.FIFTH
    }

    "그 외의 경우 MISS 등급을 반환한다" {
        LottoRanking.valueOf(2) shouldBe LottoRanking.MISS
        LottoRanking.valueOf(1) shouldBe LottoRanking.MISS
        LottoRanking.valueOf(0) shouldBe LottoRanking.MISS
    }
})
