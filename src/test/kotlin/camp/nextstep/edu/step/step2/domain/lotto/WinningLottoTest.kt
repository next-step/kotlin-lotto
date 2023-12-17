package camp.nextstep.edu.step.step2.domain.lotto

import camp.nextstep.edu.step.step2.domain.number.Number
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName

@DisplayName("당첨 로또 확인 도메인은")
class WinningLottoTest : BehaviorSpec({

    Given("당첨 로또 티켓과 보너스 숫자가 주어지고") {
        val winningLottoRequest = Lotto(
            listOf(
                Number(1),
                Number(2),
                Number(3),
                Number(4),
                Number(5),
                Number(6)
            )
        )

        val bonusNumber = Number(number = 7)
        val duplicateBonusNumber = Number(number = 6)

        When("생성을 요청하면") {
            val winningLotto = WinningLotto(
                winningLotto = winningLottoRequest,
                bonusNumber = bonusNumber
            )

            Then("정상적으로 생성된다.") {
                winningLotto.winningLotto.numbers shouldBe listOf(
                    Number(1),
                    Number(2),
                    Number(3),
                    Number(4),
                    Number(5),
                    Number(6)
                )
                winningLotto.bonusNumber shouldBe Number(number = 7)
            }
        }

        When("만약 당첨 로또 숫자들 중 보너스 숫자와 중복이 발생한다면") {
            val exceptionByDuplicateBonusNumber = shouldThrow<IllegalArgumentException> {
                WinningLotto(
                    winningLotto = winningLottoRequest,
                    bonusNumber = duplicateBonusNumber
                )
            }
            Then("예외가 발생한다.") {
                exceptionByDuplicateBonusNumber.message shouldBe "보너스 번호는 당첨 번호와 중복될 수 없습니다."
            }
        }
    }

    Given("만약 하나라도 비어있는 값이 존재하면") {
        val emptyLotto = Lotto(
            listOf()
        )

        val bonusNumber = Number(number = 7)

        When("생성 시") {
            val exceptionByEmptyLotto = shouldThrow<IllegalArgumentException> {
                WinningLotto(
                    winningLotto = emptyLotto,
                    bonusNumber = bonusNumber
                )
            }

            Then("예외가 발생한다.") {
                exceptionByEmptyLotto.message shouldBe "당첨번호가 입력되지 않았습니다."
            }
        }
    }

})

