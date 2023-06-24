package lotto.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class LottoQuantitySpec : DescribeSpec({
    describe("로또 수량 양수(0포함) 검증") {
        context("로또 수량이 1개 이면") {
            it("정상적으로 객체가 생성된다.") {
                val lottoQuantity = LottoQuantity(1)

                lottoQuantity.value shouldBe 1
            }
        }

        context("로또 수량이 0개 이면") {
            it("정상적으로 객체가 생성된다.") {
                val lottoQuantity = LottoQuantity(0)

                lottoQuantity.value shouldBe 0
            }
        }

        context("로또 수량이 음수이면") {
            it("예외가 발생한다.") {
                shouldThrowExactly<IllegalArgumentException> {
                    LottoQuantity(-1)
                }
            }
        }
    }

    describe("로또 수량 비교") {
        context("로또 수량이 1개는") {
            val lottoQuantity = LottoQuantity(1)

            it("로또 수량 0보다 크다.") {
                (lottoQuantity > LottoQuantity(0)) shouldBe true
            }

            it("로또 수량 1개와 같다.") {
                (lottoQuantity == LottoQuantity(1)) shouldBe true
            }

            it("로또 수량 2보다 작다.") {
                (lottoQuantity < LottoQuantity(2)) shouldBe true
            }
        }
    }
})
