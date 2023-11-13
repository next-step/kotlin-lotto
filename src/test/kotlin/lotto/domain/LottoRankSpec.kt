package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class LottoRankSpec : FunSpec({
    context("Rank 도출") {
        context("보너스 볼의 일치 여부와 관계 없는 Rank") {
            forAll(
                row(6, LottoRank.FIRST),
                row(4, LottoRank.FOURTH),
                row(3, LottoRank.FIFTH),
                row(2, LottoRank.MISS),
                row(1, LottoRank.MISS),
                row(0, LottoRank.MISS),
            ) { countOfMatch, expect ->

                test("보너스 볼을 맞혔을 경우 Rank 반환") {
                    val result = LottoRank.valueOf(countOfMatch, false)

                    result shouldBe expect
                }

                test("보너스 볼을 틀렸을 경우 Rank 반환") {
                    val result = LottoRank.valueOf(countOfMatch, false)

                    result shouldBe expect
                }
            }
        }

        context("5개를 맞추면 보너스 볼 여부에 따라 다른 Rank 반환") {
            val countOfMatch = 5

            test("보너스 볼을 맞혔을 경우 Rank SECOND 반환") {
                val result = LottoRank.valueOf(countOfMatch, true)

                result shouldBe LottoRank.SECOND
            }

            test("보너스 볼을 틀렸을 경우 Rank THIRD 반환") {
                val result = LottoRank.valueOf(countOfMatch, false)

                result shouldBe LottoRank.THIRD
            }
        }
    }

    context("티켓의 장수가 주어지면 상금을 곱해 총 삼금액을 계산") {

        test("티켓이 한장인 경우") {
            forAll(
                row(LottoRank.FIRST, 1, Amount(2_000_000_000)),
                row(LottoRank.SECOND, 1, Amount(30_000_000)),
                row(LottoRank.THIRD, 1, Amount(1_500_000)),
                row(LottoRank.FOURTH, 1, Amount(50_000)),
                row(LottoRank.FIFTH, 1, Amount(5_000)),
                row(LottoRank.MISS, 1, Amount(0)),
            ) { rank, count, expectTotal ->

                rank.calculateTotal(count) shouldBe expectTotal
            }
        }

        test("티켓이 여러 장인 경우") {
            forAll(
                row(LottoRank.SECOND, 2, Amount(60_000_000)),
                row(LottoRank.THIRD, 3, Amount(4_500_000)),
                row(LottoRank.FIFTH, 5, Amount(25_000)),
            ) { rank, count, expectTotal ->

                rank.calculateTotal(count) shouldBe expectTotal
            }
        }
    }
})
