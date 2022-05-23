package lotto.domain

import io.kotest.assertions.assertSoftly
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import lotto.vo.Money

class LottoRankTest : DescribeSpec({
    describe("of") {
        context("일치하는 로또 번호의 수가 6개인 경우") {
            it("1등을 반환한다 (당첨 금액 2_000_000_000)") {
                val ranking = LottoRank.of(6, false)
                assertSoftly {
                    ranking shouldBe LottoRank.FIRST
                    ranking.winningAmount shouldBe Money.of(2_000_000_000)
                }
            }
        }

        context("일치하는 로또 번호의 수가 5개이고 보너스볼이 일치할 경우") {
            it("2등을 반환한다 (당첨 금액 30_000_000)") {
                val ranking = LottoRank.of(5, true)
                assertSoftly {
                    ranking shouldBe LottoRank.SECOND
                    ranking.winningAmount shouldBe Money.of(30_000_000)
                }
            }
        }

        context("일치하는 로또 번호의 수가 5개인 경우") {
            it("3등을 반환한다 (당첨 금액 1_500_000)") {
                val ranking = LottoRank.of(5, false)
                assertSoftly {
                    ranking shouldBe LottoRank.THIRD
                    ranking.winningAmount shouldBe Money.of(1_500_000)
                }
            }
        }

        context("일치하는 로또 번호의 수가 4개인 경우") {
            it("4등을 반환한다 (당첨 금액 50_000)") {
                val ranking = LottoRank.of(4, false)
                assertSoftly {
                    ranking shouldBe LottoRank.FOURTH
                    ranking.winningAmount shouldBe Money.of(50_000)
                }
            }
        }

        context("일치하는 로또 번호의 수가 3개인 경우") {
            it("5등을 반환한다 (당첨 금액 5_000)") {
                val ranking = LottoRank.of(3, false)
                assertSoftly {
                    ranking shouldBe LottoRank.FIFTH
                    ranking.winningAmount shouldBe Money.of(5_000)
                }
            }
        }

        context("일치하는 로또 번호의 수가 0~2개인 경우") {
            it("미당첨을 반환한다 (당첨 금액 0)") {
                listOf(0, 1, 2).forAll { matchCount ->
                    val ranking = LottoRank.of(matchCount, false)
                    assertSoftly {
                        ranking shouldBe LottoRank.NOTHING
                        ranking.winningAmount shouldBe Money.ZERO
                    }
                }
            }
        }

        it("일치하는 로또 번호의 수가 0~6 사이가 아니면 IllegalArgumentException 이 발생한다") {
            listOf(-1, 7).forAll {
                shouldThrow<IllegalArgumentException> { LottoRank.of(it, false) }
            }
        }
    }
})
