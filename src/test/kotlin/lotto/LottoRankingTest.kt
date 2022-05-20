package lotto

import io.kotest.assertions.assertSoftly
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class LottoRankingTest : DescribeSpec({
    describe("of") {
        context("일치하는 로또 번호의 수가 6개인 경우") {
            it("1등을 반환한다 (당첨 금액 2_000_000_000)") {
                val ranking = LottoRanking.of(6)
                assertSoftly {
                    ranking shouldBe LottoRanking.FIRST
                    ranking.winningAmount shouldBe 2_000_000_000
                }
            }
        }

        context("일치하는 로또 번호의 수가 5개인 경우") {
            it("2등을 반환한다 (당첨 금액 1_500_000)") {
                val ranking = LottoRanking.of(5)
                assertSoftly {
                    ranking shouldBe LottoRanking.SECOND
                    ranking.winningAmount shouldBe 1_500_000
                }
            }
        }

        context("일치하는 로또 번호의 수가 4개인 경우") {
            it("3등을 반환한다 (당첨 금액 50_000)") {
                val ranking = LottoRanking.of(4)
                assertSoftly {
                    ranking shouldBe LottoRanking.THIRD
                    ranking.winningAmount shouldBe 50_000
                }
            }
        }


        context("일치하는 로또 번호의 수가 3개인 경우") {
            it("4등을 반환한다 (당첨 금액 5_000)") {
                val ranking = LottoRanking.of(3)
                assertSoftly {
                    ranking shouldBe LottoRanking.FOURTH
                    ranking.winningAmount shouldBe 5_000
                }
            }
        }

        context("일치하는 로또 번호의 수가 0~2개인 경우") {
            it("미당첨을 반환한다 (당첨 금액 0)") {
                listOf(0, 1, 2).forAll { matchCount ->
                    val ranking = LottoRanking.of(matchCount)
                    assertSoftly {
                        ranking shouldBe LottoRanking.NOTTING
                        ranking.winningAmount shouldBe 0
                    }
                }
            }
        }

        context("일치하는 로또 번호의 수가 0개 미만이거나 6개 초과인 경우") {
            it("IllegalArgumentException 예외가 발생한다") {
                listOf(-1, 7).forAll { matchCount ->
                    shouldThrow<IllegalArgumentException> {
                        LottoRanking.of(matchCount)
                    }
                }
            }
        }

    }
})
