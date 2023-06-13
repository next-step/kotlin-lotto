package next.step.lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe

class LottoTest : DescribeSpec({

    describe("Lotto 생성") {
        context("lotto 가격만큼 지불하면") {
            it("랜덤한 번호로 생성된 로또 제공") {
                Lotto.buy(Lotto.LOTTO_PRICE).numbers() shouldHaveSize 6
            }
        }

        context("lotto 가격보다 낮게 지불하면") {
            it("예외 발생") {
                shouldThrow<IllegalArgumentException> {
                    Lotto.buy(Lotto.LOTTO_PRICE - 1)
                }
            }
        }

        context("같은 LottoNumbers로 생성하면") {
            it("동등함") {
                Lotto.of(LottoNumbers.from((1..6).toSet())) shouldBe Lotto.of(LottoNumbers.from((1..6).toSet()))
            }
        }
    }

    describe("Lotto 를 살 수 있는지 판별") {
        context("lotto 가격보다 낮게 넣으면") {
            it("살 수 없다고 알려줌") {
                Lotto.canBuy(Lotto.LOTTO_PRICE - 1) shouldBe false
            }
        }

        context("lotto 가격 이상으로 넣으면") {
            it("살 수 있다고 알려줌") {
                Lotto.canBuy(Lotto.LOTTO_PRICE) shouldBe true
            }
        }
    }
})
