package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import lotto.strategy.FirstRankLottoLottoNumberGenerator
import org.junit.jupiter.api.assertThrows

class CashierTest : DescribeSpec({
    describe("입력한 금액만큼 로또를 구매한다") {
        it("1000원 보다 적은 경우 throw exception") {
            val sut = Cashier(999, FirstRankLottoLottoNumberGenerator())
            assertThrows<IllegalArgumentException> {
                sut.purchaseAutoLottos()
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
    }

    describe("수동 로또를 구매한다.") {
        lateinit var sut: Cashier
        beforeTest {
            sut = Cashier(2000, FirstRankLottoLottoNumberGenerator())
        }

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
                        sut.purchaseManualLottos(manualLottoNumbers)
                    }

                exception.message shouldBe "수동 로또 개수와 금액이 일치하지 않습니다."
            }
        }

        context("입력한 금액보다 수동로또 개수가 적은경우") {
            it("throw exception") {
                val manualLottoNumbers =
                    listOf(
                        setOf(1, 2, 3, 4, 5, 6),
                    )

                val exception =
                    shouldThrow<IllegalArgumentException> {
                        sut.purchaseManualLottos(manualLottoNumbers)
                    }

                exception.message shouldBe "수동 로또 개수와 금액이 일치하지 않습니다."
            }
        }

        context("입력한 금액보다 수동로또 개수가 같은 경우") {
            it("입력한 수동 개수만큼 로또를 리턴한다.") {
                val manualLottoNumbers =
                    listOf(
                        setOf(1, 2, 3, 4, 5, 6),
                        setOf(1, 2, 3, 4, 5, 6),
                    )

                val actual = sut.purchaseManualLottos(manualLottoNumbers)

                actual.tickets.size shouldBe manualLottoNumbers.size
            }
        }
    }
})
