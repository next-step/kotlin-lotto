package lotto

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import lotto.domain.BoughtMoney
import lotto.domain.ManualLottoAmount

class LottoGameTest : DescribeSpec({

    val sut = LottoGame()

    describe("구입 금액 처리") {
        it("구입 금액을 반환한다.") {
            val actual = sut.parseInputMoney("1000")

            actual shouldBe BoughtMoney(1000)
        }

        it("구입 금액이 존재하지 않으면 예외를 던진다.") {
            shouldThrowWithMessage<IllegalArgumentException>("구입 금액은 필수입니다.") {
                sut.parseInputMoney(null)
            }
        }

        it("구입 금액이 숫자가 아니면 예외를 던진다.") {
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

        it("수동 로또 수가 존재하지 않으면 예외를 던진다.") {
            shouldThrowWithMessage<IllegalArgumentException>("수동으로 구매할 로또 수는 필수입니다.") {
                sut.parseInputManualLottoAmount(null)
            }
        }

        it("수동 로또 수가 숫자가 아니면 예외를 던진다.") {
            shouldThrowWithMessage<IllegalArgumentException>("수동으로 구매할 로또 수는 숫자만 입력 가능합니다.") {
                sut.parseInputManualLottoAmount("abc")
            }
        }
    }

    describe("로또 생성") {
        it("구입 금액과 수동 생성 로또 번호를 받아 로또를 생성한다.") {
            val actual = sut.generateLottos(
                boughtMoney = BoughtMoney(10000),
                manualLottoAmount = ManualLottoAmount(2),
                inputManualLottoNumbers = listOf("1, 2, 3, 4, 5, 6", "7, 8, 9, 10, 11, 12")
            )

            actual.size shouldBe 10
        }

        it("수동 로또를 구매했는데 구매한 수량만큼 수동 구매 로또 번호가 없다면 예외를 던진다.") {
            shouldThrowWithMessage<IllegalArgumentException>("구매한 수동 로또 수만큼 수동 로또 번호 입력이 필요합니다.") {
                sut.generateLottos(
                    boughtMoney = BoughtMoney(10000),
                    manualLottoAmount = ManualLottoAmount(2),
                    inputManualLottoNumbers = listOf()
                )
            }
        }

        it("수동 로또를 구매했는데 누락된 로또 번호가 있다면 예외를 던진다.") {
            shouldThrowWithMessage<IllegalArgumentException>("수동 로또 번호는 입력은 필수입니다.") {
                sut.generateLottos(
                    boughtMoney = BoughtMoney(10000),
                    manualLottoAmount = ManualLottoAmount(2),
                    inputManualLottoNumbers = listOf(null, "7, 8, 9, 10, 11, abc")
                )
            }
        }

        it("수동 로또를 구매했는데 숫자가 아닌 로또 번호가 있다면 예외를 던진다.") {
            shouldThrowWithMessage<IllegalArgumentException>("수동 로또 번호는 숫자만 입력 가능합니다.") {
                sut.generateLottos(
                    boughtMoney = BoughtMoney(10000),
                    manualLottoAmount = ManualLottoAmount(1),
                    inputManualLottoNumbers = listOf("7, 8, 9, 10, 11, abc")
                )
            }
        }
    }

    describe("당첨 로또 생성") {
        it("담청 번호와 보너스 볼을 받아 당첨 로또를 생성한다.") {
            sut.generateWinningLotto("1, 2, 3, 4, 5, 6", "7")
        }

        it("당첨 번호가 존재하지 않으면 예외를 던진다.") {
            shouldThrowWithMessage<IllegalArgumentException>("지난 주 당첨 번호는 필수입니다.") {
                sut.generateWinningLotto(null, "7")
            }
        }

        it("당첨 번호가 숫자가 아니라면 예외를 던진다.") {
            shouldThrowWithMessage<IllegalArgumentException>("지난 주 당첨 번호는 숫자만 입력 가능합니다.") {
                sut.generateWinningLotto("1, 2, a, b, c, d", "7")
            }
        }

        it("보너스 볼이 존재하지 않으면 예외를 던진다.") {
            shouldThrowWithMessage<IllegalArgumentException>("보너스 볼은 필수입니다.") {
                sut.generateWinningLotto("1, 2, 3, 4, 5, 6", null)
            }
        }

        it("당첨 번호가 숫자가 아니라면 예외를 던진다.") {
            shouldThrowWithMessage<IllegalArgumentException>("보너스 볼은 숫자만 입력 가능합니다.") {
                sut.generateWinningLotto("1, 2, 3, 4, 5, 6", "a")
            }
        }
    }
})
