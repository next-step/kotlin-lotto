package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import lotto.mockLottery

class LottoResultTest : DescribeSpec({

    describe(name = "로또 결과를 구매 주문과 당첨 복권으로 생성할 수 있다.") {
        val winningLottery = mockLottery(1, 2, 3, 4, 5, 6)

        forAll(
            row(
                listOf(
                    mockLottery(1, 2, 3, 4, 5, 6),
                    mockLottery(1, 2, 3, 4, 5, 6),
                ),
                LottoRank.FIRST,
            ),
            row(listOf(mockLottery(1, 2, 3, 4, 5, 7)), LottoRank.SECOND),
            row(listOf(mockLottery(1, 2, 3, 4, 15, 7)), LottoRank.THIRD),
            row(listOf(mockLottery(1, 2, 3, 24, 15, 7)), LottoRank.FOURTH),
        ) { purchasedLotteries, lottoRank ->
            context(name = "1등부터 4등까지 당첨된 경우 당첨된 결과를 알 수 있다.") {
                val lottoResult = LottoResult(
                    purchasedLotteries = PurchasedLotteries(lotteries = purchasedLotteries),
                    winningLottery = winningLottery,
                )

                val size = purchasedLotteries.size

                it(name = "당첨 통계를 알 수 있다.") {
                    lottoResult.countNumberOfHit(lottoRank = lottoRank) shouldBe size
                }

                it(name = "수익률을 알 수 있다.") {
                    val sizeToDouble = size.toDouble()
                    val expect = (lottoRank.winningMoney * sizeToDouble) / (Lottery.LOTTERY_PRICE * sizeToDouble)
                    lottoResult.rateOfReturn shouldBe expect
                }

                it(name = "Benefit 타입이 이득으로 반환한다.") {
                    lottoResult.benefitType shouldBe BenefitType.GAIN
                }
            }
        }

        context(name = "아무런 복권이 당첨되지 않았을 때") {
            val lottoResult = LottoResult(
                purchasedLotteries = PurchasedLotteries(
                    lotteries = listOf(mockLottery(41, 32, 23, 24, 15, 7)),
                ),
                winningLottery = winningLottery,
            )

            it(name = "수익률이 0.0으로 반환된다.") {
                lottoResult.rateOfReturn shouldBe 0.0
            }

            it(name = "Benefit 타입이 손해로 반환한다.") {
                lottoResult.benefitType shouldBe BenefitType.LOSS
            }
        }

        val emptyLotteries = PurchasedLotteries(lotteries = emptyList())

        context(name = "구매한 복권이 없으면 당첨 결과가 비어있다.") {
            val lottoResult = LottoResult(purchasedLotteries = emptyLotteries, winningLottery = winningLottery)

            it(name = "당첨 통계가 비어 있다.") {
                LottoRank.values()
                    .forEach {
                        lottoResult.countNumberOfHit(lottoRank = it) shouldBe 0
                    }
            }

            it(name = "수익률이 0.0으로 반환된다.") {
                lottoResult.rateOfReturn shouldBe 0.0
            }

            it(name = "Benefit 타입이 손해로 반환한다.") {
                lottoResult.benefitType shouldBe BenefitType.LOSS
            }
        }
    }
})
