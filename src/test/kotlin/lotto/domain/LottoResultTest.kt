package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import lotto.mockLottery

class LottoResultTest : DescribeSpec({

    describe(name = "로또 결과를 구매 주문과 당첨 복권으로 생성할 수 있다.") {
        val winningLottery = mockLottery(1, 2, 3, 4, 5, 6)
        val purchasedLotteries = PurchasedLotteries(lotteries = listOf(winningLottery))

        context(name = "구매한 복권이 있으면 당첨된 결과를 알 수 있다.") {
            val lottoResult = LottoResult(purchasedLotteries = purchasedLotteries, winningLottery = winningLottery)

            it(name = "당첨 통계를 알 수 있다.") {
                lottoResult.countNumberOfHit(lottoRank = LottoRank.FIRST) shouldBe 1
            }

            it(name = "수익률을 알 수 있다.") {
                lottoResult.rateOfReturn shouldNotBe 0.0
            }
        }

        val emptyLotteries = PurchasedLotteries(lotteries = emptyList())

        context(name = "구매한 복권이 없으면 당첨 결과가 비어있다.") {
            val lottoResult = LottoResult(purchasedLotteries = emptyLotteries, winningLottery = winningLottery)

            it(name = "당첨 통계가 비어 있다.") {
                LottoRank.values()
                    .forEach {
                        lottoResult.countNumberOfHit(lottoRank = it) shouldBe null
                    }
            }

            it(name = "수익률이 0.0으로 반환된다.") {
                lottoResult.rateOfReturn shouldBe 0.0
            }
        }
    }
})
