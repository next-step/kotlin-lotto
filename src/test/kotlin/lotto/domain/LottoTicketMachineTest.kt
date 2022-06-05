package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldBeSorted
import io.kotest.matchers.shouldBe

class LottoTicketMachineTest : DescribeSpec({
    describe("generate 메서드 테스트") {
        context("0개 구매할 때") {
            it("예외를 던진다.") {
                val exception = shouldThrow<IllegalArgumentException> {
                    val givenNumber: Int = 0
                    LottoTicketMachine.generate(givenNumber)
                }
                exception.message shouldBe "1개 이상 구매해야 합니다."
            }
        }

        context("1개 이상 구매할 때") {
            val givenNumber: Int = 6
            val givenLottoTickets: LottoTickets = LottoTicketMachine.generate(givenNumber)

            it("개수 만큼 로또를 생성한다.") {
                givenLottoTickets.lottoTickets.size shouldBe 6
            }

            it("로또는 서로 다른 번호를 가진다.") {
                givenLottoTickets.lottoTickets.distinct().size shouldBe 6
            }

            it("로또 번호는 오름차순으로 정렬된다.") {
                givenLottoTickets.lottoTickets.forEach { ticket ->
                    run {
                        ticket.numbers.toList().shouldBeSorted()
                    }
                }
            }
        }
    }
})
