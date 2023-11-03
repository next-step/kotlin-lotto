package lottery.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import lottery.validator.InputValidator

class LottoGameTest : DescribeSpec({
    describe("로또 게임을 진행하여") {
        context("입력 받은 로또 금액이") {
            val purchaseAmount = 1000
            it("${purchaseAmount}원 이상이면 구매가 가능하다") {
                val game = LottoGame(purchaseAmount)

                game.amount shouldBe purchaseAmount
            }

            it("${purchaseAmount}원 보다 적으면 구매 장수는 0장이다") {
                val game = LottoGame(purchaseAmount)

                // TODO("구매 장수를 검증한다")
            }

            it("숫자가 아니면 구매가 불가능하다") {
                shouldThrow<IllegalArgumentException> {
                    InputValidator.validateAmount("lotto")
                }
            }
        }
    }
})
