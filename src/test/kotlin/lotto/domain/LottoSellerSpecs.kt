package lotto.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class LottoSellerSpecs : DescribeSpec({

    describe("로또 판매자는") {
        context("로또를 구입할 충분한 금액을 받으면") {
            val receivedMoney = Money(1_4500)
            it("(금액/로또 가격) 만큼의 로또로 구성된 로또 묶음과 잔돈을 제공한다") {
                val (lottoBundle, changes) = LottoSeller().sellAutoLotto(receivedMoney)
                lottoBundle.size shouldBe 14
                changes.amount shouldBe 500
            }
        }

        context("로또 1개의 가격보다 낮은 금액을 받으면") {
            val receivedMoney = Money(100)
            it("빈 로또 묶음과 받은 금액을 반환한다") {
                val (bundle, changes) = LottoSeller().sellAutoLotto(receivedMoney)
                bundle.isNotEmpty() shouldBe false
                changes.amount shouldBe 100
            }
        }

        context("`로또 쿠폰`과 충분한 금액을 받으면") {
            val coupons = listOf(
                lottoCoupon(1, 2, 3, 4, 5, 6),
                lottoCoupon(1, 2, 3, 4, 5, 7),
                lottoCoupon(1, 2, 3, 4, 7, 8),
            )
            val receivedMoney = Money(3500)
            it("`로또 쿠폰`에 적힌 번호에 해당하는 로또를 판매한다") {
                val (lottoBundle, changes) = LottoSeller().sellManualLotto(receivedMoney, coupons)
                lottoBundle.size shouldBe 3
                changes.amount shouldBe 500
            }
        }

        context("받은 금액이 (`로또 쿠폰` 개수 x 로또 1개 가격)보다 적은 경우") {
            val coupons = listOf(
                lottoCoupon(1, 2, 3, 4, 5, 6),
                lottoCoupon(1, 2, 3, 4, 5, 7),
                lottoCoupon(1, 2, 3, 4, 7, 8),
            )
            val receivedMoney = Money(2000)
            it("예외를 발생시킨다") {
                shouldThrowExactly<IllegalArgumentException> {
                    LottoSeller().sellManualLotto(receivedMoney, coupons)
                }
            }
        }
    }
})
