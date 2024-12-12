package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import lotto.strategy.FirstRankLottoLottoNumberGenerator

class CashierTest : DescribeSpec({
    describe("입력한 금액만큼 로또를 구매한다") {
        it("1000원 보다 적은 경우 throw exception") {
            shouldThrow<IllegalArgumentException> {
                Cashier(999, FirstRankLottoLottoNumberGenerator())
            }
        }

        it("1000원 짜리 로또를 구매한다") {
            val sut = Cashier(3000, FirstRankLottoLottoNumberGenerator())
            val actual = sut.purchaseAutoLottos()
            actual.tickets.size shouldBe 3
        }

        it("100원 단위는 내림처리 한다.") {
            val sut = Cashier(3500, FirstRankLottoLottoNumberGenerator())
            val actual = sut.purchaseAutoLottos()
            actual.tickets.size shouldBe 3
        }

        context("수동로또를 구매하고 남은 차액만큼 자동 로또를 구매한다") {
            val manualLottoNumbers =
                listOf(
                    setOf(1, 2, 3, 4, 5, 6),
                    setOf(1, 2, 3, 4, 5, 6),
                    setOf(1, 2, 3, 4, 5, 6),
                )
            val sut = Cashier(10000, FirstRankLottoLottoNumberGenerator(), ManualLotto(manualLottoNumbers))
            it("차액이 남은경우 자동로또를 생성한다") {
                val actual = sut.purchaseAutoLottos()
                actual.tickets.size shouldBe 7
            }
        }
    }

    describe("수동 로또를 구매한다.") {
        context("입력한 금액보다 수동로또 개수 많은경우") {
            it("throw exception") {
                val manualLottoNumbers =
                    listOf(
                        setOf(1, 2, 3, 4, 5, 6),
                        setOf(1, 2, 3, 4, 5, 6),
                        setOf(1, 2, 3, 4, 5, 6),
                    )

                val exception =
                    shouldThrow<IllegalArgumentException> {
                        Cashier(2000, FirstRankLottoLottoNumberGenerator(), ManualLotto(manualLottoNumbers))
                    }

                exception.message shouldBe "금액이 부족합니다."
            }
        }

        context("입력한 금액보다 수동로또 개수가 적은경우") {
            it("수동로또 개수만 리턴한다.") {
                val manualLottoNumbers =
                    listOf(
                        setOf(1, 2, 3, 4, 5, 6),
                    )

                val sut = Cashier(2000, FirstRankLottoLottoNumberGenerator(), ManualLotto(manualLottoNumbers))
                val actual = sut.purchaseManualLottos()

                actual.tickets.size shouldBe 1
            }
        }

        context("입력한 금액보다 수동로또 개수가 같은 경우") {
            it("입력한 수동 개수만큼 로또를 리턴한다.") {
                val manualLottoNumbers =
                    listOf(
                        setOf(1, 2, 3, 4, 5, 6),
                        setOf(1, 2, 3, 4, 5, 6),
                    )

                val sut = Cashier(2000, FirstRankLottoLottoNumberGenerator(), ManualLotto(manualLottoNumbers))

                val actual = sut.purchaseManualLottos()

                actual.tickets.size shouldBe manualLottoNumbers.size
            }
        }
    }
})
