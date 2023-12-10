package camp.nextstep.edu.step.step2.domain.lotto

import camp.nextstep.edu.step.step2.domain.number.Number
import io.kotest.core.annotation.DisplayName
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.assertAll

@DisplayName("로또 일급 컬렌션은")
class LottosTest : BehaviorSpec ({

    Given("내가 구매한 로또들과 지난주 당첨 객체가 주어지고") {
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

        val userLotto = Lotto(
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

        val userLottos = Lottos(lottos = listOf(userLotto))

        val winningLotto = WinningLotto(
            winningLotto = winningLottoRequest,
            bonusNumber = bonusNumber
        )

        When("당첨 로또 확인을 요청하면") {
            val lottoMatchResults = userLottos.checkLottoNumbersByWinningLotto(winningLotto)

            Then("당첨 결과가 반환된다.") {
                assertAll(
                    { lottoMatchResults.size shouldBe 1},
                    { lottoMatchResults[0].matchCount shouldBe 6},
                    { lottoMatchResults[0].bonusMatch shouldBe 0},
                    { lottoMatchResults[0].prize shouldBe 2_000_000_000}
                )
            }
        }
    }

})
