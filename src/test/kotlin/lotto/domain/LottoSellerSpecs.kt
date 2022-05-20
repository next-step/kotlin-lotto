package lotto.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class LottoSellerSpecs : DescribeSpec({

    describe("로또 판매자는") {
        context("로또를 구입할 충분한 금액을 받으면") {
            it("(금액/로또 가격) 만큼의 로또로 구성된 로또 뭉치를 제공한다") {
                val lottoBundle = LottoSeller().sell(1_4000)
                lottoBundle.bundle.size shouldBe 14
            }
        }

        context("로또 1개의 가격보다 낮은 금액을 받으면") {
            it("예외를 발생시킨다") {
                shouldThrowExactly<IllegalArgumentException> {
                    LottoSeller().sell(100)
                }
            }
        }
    }
})
