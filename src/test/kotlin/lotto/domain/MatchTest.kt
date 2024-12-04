package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class MatchTest : DescribeSpec({
    describe("사용자의 로또와 당첨로또의 숫자를 비교한다.") {
        context("우승 로또와 사용자 로또를 비교해서 일치하는 개수를 리턴한다.") {
            it("1등") {
                val actual = Match(6, false).rank()
                actual shouldBe 1
            }

            it("2등") {
                val actual = Match(5, true).rank()
                actual shouldBe 2
            }

            it("3등") {
                val actual = Match(5, false).rank()
                actual shouldBe 3
            }

            it("4등") {
                val actual = Match(4, true).rank()
                actual shouldBe 4
            }

            it("5등") {
                val actual = Match(3, true).rank()
                actual shouldBe 5
            }

            it("낙첨") {
                val actual = Match(2, true).rank()
                actual shouldBe 0
            }
        }
    }
})
