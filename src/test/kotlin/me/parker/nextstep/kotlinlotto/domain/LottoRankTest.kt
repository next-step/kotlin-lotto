package me.parker.nextstep.kotlinlotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class LottoRankTest : DescribeSpec({

    describe("LottoRank는") {
        context("matchCount가 6이면") {
            it("FIRST를 반환한다.") {
                LottoRank.of(6) shouldBe LottoRank.FIRST
            }
        }

        context("matchCount가 5이면") {
            it("SECOND를 반환한다.") {
                LottoRank.of(5) shouldBe LottoRank.SECOND
            }
        }

        context("matchCount가 4이면") {
            it("THIRD를 반환한다.") {
                LottoRank.of(4) shouldBe LottoRank.THIRD
            }
        }

        context("matchCount가 3이면") {
            it("FOURTH를 반환한다.") {
                LottoRank.of(3) shouldBe LottoRank.FOURTH
            }
        }

        context("matchCount가 2이하면") {
            it("MISS를 반환한다.") {
                LottoRank.of(2) shouldBe LottoRank.MISS
                LottoRank.of(1) shouldBe LottoRank.MISS
                LottoRank.of(0) shouldBe LottoRank.MISS
            }
        }
    }

})
