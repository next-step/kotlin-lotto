package me.parker.nextstep.kotlinlotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.shouldBe

class LottoTicketMachineTest : DescribeSpec({
    describe("LottoTicketMachine은") {
        context("정상적인 구매할 돈과 수동 로또 번호 리스트를 입력하면") {
            it("입력한 수동 번호 로도 번호를 포함한 구매한 전체 로또 티켓 리스트를 반환한다.") {
                val manualLottoNumbers = listOf(
                    listOf(8, 21, 23, 41, 42, 43),
                    listOf(3, 5, 11, 16, 32, 38),
                    listOf(7, 11, 16, 35, 36, 44),
                )
                val lottoTicketMachine = LottoTicketMachine(13_000, manualLottoNumbers)

                val purchasedLottoTickets = lottoTicketMachine.purchase()

                purchasedLottoTickets.size shouldBe 13
                manualLottoNumbers.forEach {
                    purchasedLottoTickets.map { ticket -> ticket.lottoNumbers } shouldContain LottoNumbers(
                        ManualLottoNumbersGenerationRule(it)
                    )
                }
            }

            it("입력한 수동 번호 로도 번호를 포함한 구매한 전체 로또 티켓 리스트를 반환한다.") {
                val manualLottoNumbers = listOf(
                    listOf(8, 21, 23, 41, 42, 43),
                    listOf(3, 5, 11, 16, 32, 38),
                    listOf(7, 11, 16, 35, 36, 44),
                )
                val lottoTicketMachine = LottoTicketMachine(9_500, manualLottoNumbers)

                val purchasedLottoTickets = lottoTicketMachine.purchase()

                purchasedLottoTickets.size shouldBe 9
                manualLottoNumbers.forEach {
                    purchasedLottoTickets.map { ticket -> ticket.lottoNumbers } shouldContain LottoNumbers(ManualLottoNumbersGenerationRule(it))
                }
            }
        }

        context("구매할 돈 0과 빈 수동 번호 리스트를 입력하면") {
            it("빈 LottoTicket 리스트를 반환한다.") {
                val lottoTicketMachine = LottoTicketMachine(0, listOf())

                val purchasedLottoTickets = lottoTicketMachine.purchase()

                purchasedLottoTickets.size shouldBe 0
            }
        }

        context("구매할 돈으로 구매한 로또 개수보다 수동 번호 리스트 개수가 더 크면") {
            it("구매할 수 없다는 예외가 발생한다.") {
                val manualLottoNumbers = listOf(
                    listOf(8, 21, 23, 41, 42, 43),
                    listOf(3, 5, 11, 16, 32, 38),
                    listOf(7, 11, 16, 35, 36, 44),
                )

                shouldThrow<IllegalArgumentException> {
                    LottoTicketMachine(1_000, manualLottoNumbers)
                }.message shouldBe "구매할 수 있는 로또 개수보다 많은 수동 로또 번호를 입력할 수 없습니다."
            }
        }
    }
})
