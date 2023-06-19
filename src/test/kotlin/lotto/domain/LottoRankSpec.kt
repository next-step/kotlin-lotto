package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class LottoRankSpec : DescribeSpec({
    describe("로또 순위 반환 검증") {
        context("당첨 번호와 6개 동일하면") {
            it("1등을 반환한다.") {
                val lottoRank = LottoRank.of(6, false)

                lottoRank shouldBe LottoRank.FIRST
            }
        }

        context("당첨 번호와 5개 동일하고 보너스 번호가 일치하면") {
            it("2등을 반환한다.") {
                val lottoRank = LottoRank.of(5, true)

                lottoRank shouldBe LottoRank.SECOND
            }
        }

        context("당첨 번호와 5개 동일하면") {
            it("3등을 반환한다.") {
                val lottoRank = LottoRank.of(5, false)

                lottoRank shouldBe LottoRank.THIRD
            }
        }

        context("당첨 번호와 4개 동일하면") {
            it("4등을 반환한다.") {
                val lottoRank = LottoRank.of(4, false)

                lottoRank shouldBe LottoRank.FOURTH
            }
        }

        context("당첨 번호와 3개 동일하면") {
            it("5등을 반환한다.") {
                val lottoRank = LottoRank.of(3, false)

                lottoRank shouldBe LottoRank.FIFTH
            }
        }
    }

    describe("로또 순위 맵 생성 검증 (key: 로또 순위, value: 0)") {
        it("로또 순위와 0을 가진 맵을 생성한다.") {
            val lottoRankMap = LottoRank.createMapWithLottoRankAndZero()

            lottoRankMap shouldBe mutableMapOf(
                LottoRank.FIRST to 0,
                LottoRank.SECOND to 0,
                LottoRank.THIRD to 0,
                LottoRank.FOURTH to 0,
                LottoRank.FIFTH to 0,
            )
        }
    }
})
