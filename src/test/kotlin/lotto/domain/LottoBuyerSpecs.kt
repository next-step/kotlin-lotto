package lotto.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import lotto.domain.WinningPlace.BLANK
import lotto.domain.WinningPlace.FIFTH
import lotto.domain.WinningPlace.FIRST
import lotto.domain.WinningPlace.FOURTH
import lotto.domain.WinningPlace.SECOND
import lotto.domain.WinningPlace.THIRD
import lotto.domain.WinningPlace.values

class LottoBuyerSpecs : DescribeSpec({
    isolationMode = IsolationMode.InstancePerLeaf

    val lottoList = mutableListOf(
        lotto(1, 2, 3, 4, 5, 6), // 1등
        lotto(1, 2, 3, 4, 5, 7), // 2등
        lotto(1, 2, 3, 4, 5, 8), // 3등
        lotto(1, 2, 3, 4, 8, 9), // 4등
        lotto(1, 2, 3, 9, 10, 11), // 5등
        lotto(1, 2, 7, 9, 10, 11), // 꽝
    )

    describe("로또 구매자는") {
        context("로또를 구매할 금액이 있으면") {
            val lottoGenerator = FixedLottoGenerator(lottoList)
            val lottoSeller = LottoSeller(lottoGenerator)
            val buyer = LottoBuyer(Money(4_000), lottoSeller = lottoSeller)
            it("로또 뭉치를 구매할 수 있다") {
                buyer.buyAll()
                buyer.getLottoBundle().size shouldBe 4
                buyer.money.amount shouldBe 0
            }

            it("`로또 쿠폰`에 해당하는 로또를 구입할 수 있다.") {
                val lottoCoupon = listOf(
                    lottoCoupon(1, 2, 3, 4, 5, 6),
                    lottoCoupon(1, 2, 3, 4, 5, 7),
                    lottoCoupon(1, 2, 3, 4, 7, 8),
                )
                buyer.buy(lottoCoupon)
                buyer.getLottoBundle().size shouldBe 3
                buyer.money.amount shouldBe 1_000
            }
        }

        context("로또를 구매할 금액이 부족하다면") {
            val buyer = LottoBuyer(Money(100))
            it("로또를 구매하지 못한다") {
                buyer.buyAll()
                buyer.getLottoBundle().size shouldBe 0
                buyer.money.amount shouldBe 100
            }
        }

        context("로또 묶음이 있고 당첨 번호를 알고 있다면") {
            val lottoBundle = LottoBundle(lottoList)
            val buyer = LottoBuyer(Money(7_000), lottoBundle)
            val winningLotto = WinningLotto(lotto(1, 2, 3, 4, 5, 6), LottoNumber.of(7))
            it("로또 당첨 결과를 확인할 수 있다") {
                buyer.confirm(winningLotto).also { winningResult ->
                    winningResult.rateOfReturn shouldBe values().sumOf { it.reward } / 7_000.0
                    winningResult[FIRST] shouldBe 1
                    winningResult[SECOND] shouldBe 1
                    winningResult[THIRD] shouldBe 1
                    winningResult[FOURTH] shouldBe 1
                    winningResult[FIFTH] shouldBe 1
                    winningResult[BLANK] shouldBe 1
                }
            }
        }

        context("로또 묶음을 보유하지 않았으면") {
            val buyer = LottoBuyer(Money(4_000))
            val winningLotto = WinningLotto(lotto(1, 2, 3, 4, 5, 6), LottoNumber.of(7))
            it("로또 당첨 결과를 확인할 수 없다") {
                shouldThrowExactly<IllegalStateException> {
                    buyer.confirm(winningLotto)
                }
            }
        }
    }
})
