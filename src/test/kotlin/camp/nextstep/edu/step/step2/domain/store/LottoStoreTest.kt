package camp.nextstep.edu.step.step2.domain.store

import camp.nextstep.edu.step.step2.domain.amount.BuyAmount
import camp.nextstep.edu.step.step2.domain.lotto.Lotto
import camp.nextstep.edu.step.step2.domain.lotto.Lottos
import camp.nextstep.edu.step.step2.domain.lotto.WinningLotto
import camp.nextstep.edu.step.step2.domain.number.Number
import camp.nextstep.edu.step.step2.domain.result.LottoMatch
import camp.nextstep.edu.step.step2.domain.result.LottoResult
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import java.math.BigDecimal

@DisplayName("로또 상점은")
class LottoStoreTest : BehaviorSpec({

    Given("구입 금액과 수동 로또 개수가 주어지고") {
        val buyAmount = BuyAmount(amount = BigDecimal.valueOf(10000L))
        val manualTicketAmount = 2

        When("로또를 구매하면") {
            val lottoTickets = LottoStore.buyAutoLottoTickets(buyAmount, manualTicketAmount)

            Then("구매한 금액만큼의 로또 티켓 수를 반환한다.") {
                lottoTickets.lottoTicketAmount shouldBe 8
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

        val userLottos = Lottos(lottos = lottoNumbers)

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

        val bonusNumber = Number(number = 7)

        val winningLotto = WinningLotto(
            winningLotto = lastWeekWinningLottoLotto,
            bonusNumber = bonusNumber
        )

        When("로또 번호를 검증하면") {
            val lottoResult =
                LottoStore.checkLottoTicketsWinningResult(
                    userLottos = userLottos,
                    winningLotto = winningLotto
                )

            Then("로또 결과를 반환한다.") {
                lottoResult shouldBe LottoResult(
                    lottoTotalPrice = 1000,
                    lottoResults = listOf(
                        LottoMatch.of(
                            matchCount = 6,
                            bonusMatch = 0
                        )
                    )
                )
            }
        }
    }

    Given("로또의 수량과 수동 로또번호가 주어지고") {
        val lottoTicketAmount = LottoTicketAmount(lottoTicketAmount = 10)
        val manualLotto = Lottos( lottos = listOf(
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
        ))

        When("로또 발급을 시도하면") {
            val lottoTickets =
                LottoStore.createNumbersByLottoTicketAmount(ticketAmount = lottoTicketAmount, manualLottos = manualLotto)

            Then("구매한 수량만큼의 로또가 발급된다.") {
                lottoTickets.lottos.size shouldBe 10
            }
        }
    }

    Given("유저의 로또와 저번주 당첨번호가 주어지고") {
        val userLottos = Lottos(
            lottos = listOf(
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

        val bonusNumber = Number(number = 7)

        val winningLotto = WinningLotto(
            winningLotto = lastWeekWinningLottoLotto,
            bonusNumber = bonusNumber
        )

        When("당첨 결과를 확인하면") {
            val lottoResult = LottoStore.checkLottoTicketsWinningResult(
                userLottos = userLottos,
                winningLotto = winningLotto
            )

            Then("당첨 결과를 반환한다.") {
                lottoResult shouldBe LottoResult(
                    lottoTotalPrice = 1000,
                    lottoResults = listOf(
                        LottoMatch.of(
                            matchCount = 6,
                            bonusMatch = 0
                        )
                    )
                )
            }
        }
    }
})
