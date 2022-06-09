package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class LottoStoreTest : DescribeSpec({
    describe("buyAutoLottoTicket 메서드 테스트") {
        context("구입 금액이 1000원 이상일 때") {
            it("수동 구매하지 않는다면, 자동 구매 횟수는 동일하다.") {
                val givenMoney = 14000
                val givenManualCount = 0
                val lottoTickets: LottoTickets = LottoStore.buyAutoLottoTicket(givenMoney, givenManualCount)

                lottoTickets.lottoTickets.size shouldBe 14
            }

            it("수동 구매를 한다면, 자동 구매 횟수는 수동 구매 횟수 만큼 줄어든다.") {
                val givenMoney = 14000
                val givenManualCount = 10
                val lottoTickets: LottoTickets = LottoStore.buyAutoLottoTicket(givenMoney, givenManualCount)

                lottoTickets.lottoTickets.size shouldBe 4
            }
        }

        context("구입 금액이 1000원 미만일 때") {
            it("예외를 던진다.") {
                val exception = shouldThrow<IllegalArgumentException> {
                    val givenMoney: Int = 100
                    val givenManualCount = 0
                    LottoStore.buyAutoLottoTicket(givenMoney, givenManualCount)
                }
                exception.message shouldBe "금액이 부족합니다."
            }
        }
    }

    describe("checkBuyAutoLotto 메서드 테스트") {
        context("전체 구매 금액이 수동 구매 금액 보다 크다면") {
            it("검증에 성공한다.") {
                val givenMoney: Int = 10000
                val givenManualCount = 5

                LottoStore.checkBuyAutoLotto(givenMoney, givenManualCount)
            }
        }

        context("전체 구매 금액이 수동 구매 금액 보다 작다면") {
            it("예외를 던진다.") {
                val exception = shouldThrow<IllegalArgumentException> {
                    val givenMoney: Int = 10000
                    val givenManualCount = 11
                    LottoStore.checkBuyAutoLotto(givenMoney, givenManualCount)
                }
            }
        }
    }
})
