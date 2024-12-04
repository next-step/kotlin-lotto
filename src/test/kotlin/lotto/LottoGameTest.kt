package lotto

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import lotto.domain.BoughtMoney

class LottoGameTest : DescribeSpec({

    val sut = LottoGame()

    describe("구입 금액 처리") {
        it("구입 금액을 반환한다.") {
            val actual = sut.parseInputMoney("1000")

            actual shouldBe BoughtMoney(1000)
        }

        it("구입 금액이 존재하지 않으면 예외를 반환한다.") {
            shouldThrowWithMessage<IllegalArgumentException>("구입 금액은 필수입니다.") {
                sut.parseInputMoney(null)
            }
        }

        it("구입 금액이 숫자가 아니면 예외를 반환한다.") {
            shouldThrowWithMessage<IllegalArgumentException>("구입 금액은 숫자만 입력가능합니다.") {
                sut.parseInputMoney("abc")
            }
        }
    }

    describe("수동 로또 수 처리") {
        it("수동 로또 수를 반환한다.") {
            val actual = sut.parseInputManualLottoAmount("3")

            actual shouldBe 3
        }

        it("수동 로또 수가 존재하지 않으면 예외를 반환한다.") {
            shouldThrowWithMessage<IllegalArgumentException>("수동으로 구매할 로또 수는 필수입니다.") {
                sut.parseInputManualLottoAmount(null)
            }
        }

        it("수동 로또 수가 숫자가 아니면 예외를 반환한다.") {
            shouldThrowWithMessage<IllegalArgumentException>("수동으로 구매할 로또 수는 숫자만 입력 가능합니다.") {
                sut.parseInputManualLottoAmount("abc")
            }
        }
    }
})
