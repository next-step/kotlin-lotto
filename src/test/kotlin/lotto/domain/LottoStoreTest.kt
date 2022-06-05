package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class LottoStoreTest : DescribeSpec({
    describe("buyLotto 메서드 테스트") {
        context("구입 금액이 1000원 이상일 때") {
            it("로또를 구입한다.") {
                val givenMoney: Int = 14000
                val lottoTickets: LottoTickets = LottoStore.buyLottoTicket(givenMoney)

                lottoTickets.lottoTickets.size shouldBe 14
            }
        }

        context("구입 금액이 1000원 미만일 때") {
            it("예외를 던진다.") {
                val exception = shouldThrow<IllegalArgumentException> {
                    val givenMoney: Int = 100
                    LottoStore.buyLottoTicket(givenMoney)
                }
                exception.message shouldBe "금액이 부족합니다."
            }
        }
    }
})
