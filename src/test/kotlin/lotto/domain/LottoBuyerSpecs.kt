package lotto.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import lotto.domain.WinningPlace.values

class LottoBuyerSpecs : DescribeSpec({

    val lottoList = listOf(
        Lotto.of(listOf(1, 2, 3, 4, 5, 6)), // 1등
        Lotto.of(listOf(1, 2, 3, 4, 5, 7)), // 2등
        Lotto.of(listOf(1, 2, 3, 4, 8, 9)), // 3등
        Lotto.of(listOf(1, 2, 3, 9, 10, 11)), // 4등
        Lotto.of(listOf(1, 2, 7, 9, 10, 11)), // 꽝
    )

    val money = 4_000

    describe("로또 구매자는") {
        context("로또를 구매할 금액이 있으면") {
            val lottoGenerator = FixedLottoGenerator(lottoList.toMutableList())
            val lottoSeller = LottoSeller(lottoGenerator)
            val buyer = LottoBuyer(money, lottoSeller)
            it("로또 뭉치를 구매할 수 있다") {
                buyer.buyAll()
            }
        }

        context("로또를 구매할 금액이 부족하다면") {
            val lottoGenerator = FixedLottoGenerator(lottoList.toMutableList())
            val lottoSeller = LottoSeller(lottoGenerator)
            val buyer = LottoBuyer(100, lottoSeller)
            it("로또를 구매할 수 없다") {
                shouldThrowExactly<IllegalArgumentException> {
                    buyer.buyAll()
                }
            }
        }

        context("로또 뭉치가 있고 당첨 번호를 알고 있다면") {
            val lottoBundle = LottoBundle(lottoList)
            val buyer = LottoBuyer(money, ownLottoBundle = lottoBundle)
            val winningNumber = WinningNumber(setOf(1, 2, 3, 4, 5, 6))
            it("로또 당첨 결과를 확인할 수 있다") {
                buyer.confirmWinning(winningNumber).also { winningResult ->
                    winningResult.rateOfReturn shouldBe values().sumOf { it.reward } / money.toDouble()
                    winningResult.first shouldBe 1
                    winningResult.second shouldBe 1
                    winningResult.third shouldBe 1
                    winningResult.fourth shouldBe 1
                }
            }
        }

        context("로또 뭉치를 보유하지 않았으면") {
            val buyer = LottoBuyer(money)
            val winningNumber = WinningNumber(setOf(1, 2, 3, 4, 5, 6))
            it("로또 당첨 결과를 확인할 수 없다") {
                shouldThrowExactly<IllegalStateException> {
                    buyer.confirmWinning(winningNumber)
                }
            }
        }
    }
})
