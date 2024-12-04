package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class MatchTest : DescribeSpec({
    describe("사용자의 로또와 당첨로또의 숫자를 비교한다.") {
        context("우승 로또와 사용자 로또를 비교해서 일치하는 개수를 리턴한다.") {
            it("1등") {
                val actual = Match(6, false).rank()
                actual shouldBe LottoRank.FIRST
            }

            it("2등") {
                val actual = Match(5, true).rank()
                actual shouldBe LottoRank.SECOND
            }

            it("3등") {
                val actual = Match(5, false).rank()
                actual shouldBe LottoRank.THIRD
            }

            it("4등") {
                val actual = Match(4, true).rank()
                actual shouldBe LottoRank.FOURTH
            }

            it("5등") {
                val actual = Match(3, true).rank()
                actual shouldBe LottoRank.FIFTH
            }

            it("낙첨") {
                val actual = Match(2, true).rank()
                actual shouldBe LottoRank.NONE
            }
        }
    }
})
