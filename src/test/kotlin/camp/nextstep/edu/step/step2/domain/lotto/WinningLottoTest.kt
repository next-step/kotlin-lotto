package camp.nextstep.edu.step.step2.domain.lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName

@DisplayName("당첨 로또 확인 도메인은")
class WinningLottoTest : BehaviorSpec({

    Given("유저 티켓번호들과 이전 당첨 로또가 주어지고") {
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

        When("생성을 요청하면") {
            val winningLotto = WinningLotto(
                winningLotto = winningLottoRequest
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
            }

        }
    }

    Given("만약 하나라도 비어있는 값이 존재하면") {
        val emptyLotto = Lotto(
            listOf()
        )

        When("생성 시") {
            val exceptionByEmptyLotto = shouldThrow<IllegalArgumentException> {
                WinningLotto(
                    winningLotto = emptyLotto
                )
            }

            Then("예외가 발생한다.") {
                exceptionByEmptyLotto.message shouldBe "당첨번호가 입력되지 않았습니다."
            }
        }
    }

})
