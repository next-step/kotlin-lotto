package me.parker.nextstep.kotlinlotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class LottoRankTest : DescribeSpec({

    describe("LottoRank는") {
        context("matchCount가 6이고, 보너스 볼 번호 매칭 여부에 상관없이") {
            it("FIRST를 반환한다.") {
                LottoRank.of(6, true) shouldBe LottoRank.FIRST
                LottoRank.of(6, false) shouldBe LottoRank.FIRST
            }
        }

        context("matchCount가 5 & 보너스 볼 번호 매칭 여부가 true 이면") {
            it("SECOND를 반환한다.") {
                LottoRank.of(5, true) shouldBe LottoRank.SECOND
            }
        }

        context("matchCount가 5 & 보너스 볼 번호 매칭 여부가 false 이면") {
            it("THIRD를 반환한다.") {
                LottoRank.of(5, false) shouldBe LottoRank.THIRD
            }
        }

        context("matchCount가 4이고, 보너스 볼 번호 매칭 여부에 상관없이") {
            it("FOURTH를 반환한다.") {
                LottoRank.of(4, true) shouldBe LottoRank.FOURTH
                LottoRank.of(4, false) shouldBe LottoRank.FOURTH
            }
        }

        context("matchCount가 3이고, 보너스 볼 번호 매칭 여부에 상관없이") {
            it("FIFTH를 반환한다.") {
                LottoRank.of(3, true) shouldBe LottoRank.FIFTH
                LottoRank.of(3, false) shouldBe LottoRank.FIFTH
            }
        }

        context("matchCount가 2이하이고, 보너스 볼 번호 매칭 여부에 상관없이") {
            it("MISS를 반환한다.") {
                LottoRank.of(2, true) shouldBe LottoRank.MISS
                LottoRank.of(2, false) shouldBe LottoRank.MISS
                LottoRank.of(1, true) shouldBe LottoRank.MISS
                LottoRank.of(1, false) shouldBe LottoRank.MISS
                LottoRank.of(0, true) shouldBe LottoRank.MISS
                LottoRank.of(0, false) shouldBe LottoRank.MISS
            }
        }
    }

})
