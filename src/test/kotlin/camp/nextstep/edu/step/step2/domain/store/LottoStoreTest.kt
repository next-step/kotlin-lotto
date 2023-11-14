package camp.nextstep.edu.step.step2.domain.store

import camp.nextstep.edu.step.step2.domain.amount.BuyAmount
import camp.nextstep.edu.step.step2.domain.lotto.Lotto
import camp.nextstep.edu.step.step2.domain.lotto.Number
import camp.nextstep.edu.step.step2.domain.lotto.WinningLotto
import camp.nextstep.edu.step.step2.domain.result.LottoMatch
import camp.nextstep.edu.step.step2.domain.result.LottoResult
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import java.math.BigDecimal

@DisplayName("로또 상점은")
class LottoStoreTest : BehaviorSpec({

    Given("구입 금액이 주어지고") {
        val buyAmount = BuyAmount(amount = BigDecimal.valueOf(10000L))

        When("로또를 구매하면") {
            val lottoTickets = LottoStore.buyLottoTickets(buyAmount)

            Then("구매한 금액만큼의 로또 티켓 수를 반환한다.") {
                lottoTickets.lottoTicketAmount shouldBe 10
            }
        }
    }

    Given("로또번호와 이전 당첨번호를 입력하게되고") {
        val lottoNumbers = listOf(
            Lotto(
                listOf(
                    Number(number = 1),
                    Number(number = 2),
                    Number(number = 3),
                    Number(number = 4),
                    Number(number = 5),
                    Number(number = 6)
                )
            )
        )

        val lastWeekWinningLottoLotto = Lotto(
            listOf(
                Number(number = 1),
                Number(number = 2),
                Number(number = 3),
                Number(number = 4),
                Number(number = 5),
                Number(number = 6)
            )
        )

        val winningLotto = WinningLotto(
            userLottoTickets = lottoNumbers,
            winningLotto = lastWeekWinningLottoLotto
        )

        When("로또 번호를 검증하면") {
            val lottoResult =
                LottoStore.checkLottoTicketsWinningResult(winningLotto = winningLotto)

            Then("로또 결과를 반환한다.") {
                lottoResult shouldBe LottoResult(
                    lottoTotalPrice = 1000,
                    lottoResults = listOf(
                        LottoMatch.of(
                            matchCount = 6
                        )
                    )
                )
            }
        }
    }
})
