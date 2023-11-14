package camp.nextstep.edu.step.step2.domain.lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName

@DisplayName("당첨 로또 확인 도메인은")
class WinningLottoTest : BehaviorSpec({

    Given("유저 티켓번호들과 이전 당첨 로또가 주어지고") {
        val userLottoTickets = listOf(
            Lotto(
                listOf(
                    Number(1),
                    Number(2),
                    Number(3),
                    Number(4),
                    Number(5),
                    Number(6)
                )
            )
        )

        val winningLotto = Lotto(
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
                userLottoTickets = userLottoTickets,
                winningLotto = winningLotto
            )

            Then("정상적으로 생성된다.") {
                winningLotto.winningLotto shouldBe Lotto(
                    listOf(
                        Number(1),
                        Number(2),
                        Number(3),
                        Number(4),
                        Number(5),
                        Number(6)
                    )
                )

                winningLotto.userLottoTickets shouldBe listOf(
                    Lotto(
                        listOf(
                            Number(1),
                            Number(2),
                            Number(3),
                            Number(4),
                            Number(5),
                            Number(6)
                        )
                    )
                )
            }

        }
    }

    Given("만약 하나라도 비어있는 값이 존재하면") {
        val winningLotto = Lotto(
            listOf(
                Number(1),
                Number(2),
                Number(3),
                Number(4),
                Number(5),
                Number(6)
            )
        )

        val emptyUserLotto = emptyList<Lotto>()

        When("생성 시") {
            val exceptionByEmptyUserLotto = shouldThrow<IllegalArgumentException> {
                WinningLotto(
                    userLottoTickets = emptyUserLotto,
                    winningLotto = winningLotto
                )
            }

            Then("예외가 발생한다.") {
                exceptionByEmptyUserLotto.message shouldBe "구매한 로또가 없습니다."
            }
        }
    }


    Given("티켓의 가격이 주어지면") {
        val ticketPrice = 1000L

        val userLottoTickets = listOf(
            Lotto(
                listOf(
                    Number(1),
                    Number(2),
                    Number(3),
                    Number(4),
                    Number(5),
                    Number(6)
                )
            ),
            Lotto(
                listOf(
                    Number(1),
                    Number(2),
                    Number(3),
                    Number(4),
                    Number(5),
                    Number(6)
                )
            )
        )

        val winningLotto = Lotto(
            listOf(
                Number(1),
                Number(2),
                Number(3),
                Number(4),
                Number(5),
                Number(6)
            )
        )

        val winningLottoDomain = WinningLotto(
            userLottoTickets = userLottoTickets,
            winningLotto = winningLotto
        )

        When("총 계산금액 요청 시") {
            val totalPrice = winningLottoDomain
                .getTotalPriceByLottoAmountAndTicketPrice(ticketPrice = ticketPrice)

            Then("정상적으로 계산된다.") {
                totalPrice shouldBe 2000L
            }
        }
    }


    Given("생성된 상태에서") {
        val userLottoTickets = listOf(
            Lotto(
                listOf(
                    Number(1),
                    Number(2),
                    Number(3),
                    Number(4),
                    Number(5),
                    Number(6)
                )
            ),
            Lotto(
                listOf(
                    Number(1),
                    Number(2),
                    Number(3),
                    Number(4),
                    Number(5),
                    Number(6)
                )
            )
        )

        val winningLotto = Lotto(
            listOf(
                Number(1),
                Number(2),
                Number(3),
                Number(4),
                Number(5),
                Number(6)
            )
        )

        val winningLottoDomain = WinningLotto(
            userLottoTickets = userLottoTickets,
            winningLotto = winningLotto
        )

        When("당첨번호를 조회하게 되면") {
            val lottoMatchResult = winningLottoDomain.getLottoMatchResult()

            Then("정상적으로 조회가 가능하다.") {
                lottoMatchResult.size shouldBe 2
            }
        }
    }

})
