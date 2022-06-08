package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class LottoPrizePolicyTest : DescribeSpec({
    describe("보너스 포함 여부 상관 없이 당첨 번호가 일치하는 우승 정책") {
        it("당첨 번호만 일치하는 경우 우승") {

            // given
            val wonMatchedCount = 3
            val wonPrize = Money(3000)
            val lottoPrizePolicy = LottoPrizePolicy(wonMatchedCount, wonPrize, null)
            val wonLottoTicket = LottoTicket.ofInts(listOf(1, 2, 3, 10, 20, 30))
            val winningLottoNumbers = WinningLottoNumbers(LottoTicketNumbers.ofInts(listOf(1, 2, 3, 4, 5, 6)), LottoTicketNumber(7))

            // when
            val prize =
                lottoPrizePolicy.won(wonLottoTicket, winningLottoNumbers)

            // then
            prize shouldBe Money(3000)
        }

        it("당첨 번호, 보너스 번호 일치하는 경우 우승") {
            // given
            val wonMatchedCount = 3
            val wonPrize = Money(3000)
            val lottoPrizePolicy = LottoPrizePolicy(wonMatchedCount, wonPrize, null)
            val wonLottoTicket = LottoTicket.ofInts(listOf(1, 2, 3, 7, 20, 30))
            val winningLottoNumbers = WinningLottoNumbers(LottoTicketNumbers.ofInts(listOf(1, 2, 3, 4, 5, 6)), LottoTicketNumber(7))

            // when
            val prize =
                lottoPrizePolicy.won(wonLottoTicket, winningLottoNumbers)

            // then
            prize shouldBe Money(3000)
        }

        it("우승하지 못한 경우 상품을 주지 않는다") {
            // given
            val wonMatchedCount = 3
            val wonPrize = Money(3000)
            val lottoPrizePolicy = LottoPrizePolicy(wonMatchedCount, wonPrize, null)
            val defeatedLottoTicket = LottoTicket.ofInts(listOf(1, 2, 40, 10, 20, 30))
            val winningLottoNumbers = WinningLottoNumbers(LottoTicketNumbers.ofInts(listOf(1, 2, 3, 4, 5, 6)), LottoTicketNumber(7))

            // when
            val prize =
                lottoPrizePolicy.won(defeatedLottoTicket, winningLottoNumbers)

            // then
            prize shouldBe null
        }
    }
    describe("보너스 번호는 일치하지 않고 당첨 번호만 일치하는 우승 정책") {
        it("당첨 번호만 일치하는 경우 우승") {
            // given
            val wonMatchedCount = 3
            val wonPrize = Money(3000)
            val lottoPrizePolicy = LottoPrizePolicy(wonMatchedCount, wonPrize, false)
            val wonLottoTicket = LottoTicket.ofInts(listOf(1, 2, 3, 10, 20, 30))
            val winningLottoNumbers = WinningLottoNumbers(LottoTicketNumbers.ofInts(listOf(1, 2, 3, 4, 5, 6)), LottoTicketNumber(7))

            // when
            val prize =
                lottoPrizePolicy.won(wonLottoTicket, winningLottoNumbers)

            // then
            prize shouldBe Money(3000)
        }

        it("보너스 번호까지 일치하는 경우 패배") {
            // given
            val wonMatchedCount = 3
            val wonPrize = Money(3000)
            val lottoPrizePolicy = LottoPrizePolicy(wonMatchedCount, wonPrize, false)
            val wonLottoTicket = LottoTicket.ofInts(listOf(1, 2, 3, 7, 20, 30))
            val winningLottoNumbers = WinningLottoNumbers(LottoTicketNumbers.ofInts(listOf(1, 2, 3, 4, 5, 6)), LottoTicketNumber(7))

            // when
            val prize =
                lottoPrizePolicy.won(wonLottoTicket, winningLottoNumbers)

            // then
            prize shouldBe null
        }

        it("당첨 번호, 보너스 번호 일치하지 않는 경우 패배") {
            // given
            val wonMatchedCount = 3
            val wonPrize = Money(3000)
            val lottoPrizePolicy = LottoPrizePolicy(wonMatchedCount, wonPrize, false)
            val defeatedLottoTicket = LottoTicket.ofInts(listOf(1, 2, 40, 10, 20, 30))
            val winningLottoNumbers = WinningLottoNumbers(LottoTicketNumbers.ofInts(listOf(1, 2, 3, 4, 5, 6)), LottoTicketNumber(7))

            // when
            val prize =
                lottoPrizePolicy.won(defeatedLottoTicket, winningLottoNumbers)

            // then
            prize shouldBe null
        }
    }

    describe("보너스 볼까지 일치하는 우승 정책") {
        it("당첨 번호, 보너스 볼까지 일치하는 경우 우승 상품을 받는다") {
            // given
            val wonMatchedCount = 3
            val wonPrize = Money(3000)
            val lottoPrizePolicy = LottoPrizePolicy(wonMatchedCount, wonPrize, true)
            val wonLottoTicket = LottoTicket.ofInts(listOf(1, 2, 3, 7, 20, 30))
            val winningLottoNumbers = WinningLottoNumbers(LottoTicketNumbers.ofInts(listOf(1, 2, 3, 4, 5, 6)), LottoTicketNumber(7))

            // when
            val prize =
                lottoPrizePolicy.won(wonLottoTicket, winningLottoNumbers)

            // then
            prize shouldBe Money(3000)
        }
        it("당첨 번호만 일치하는 경우 패배로 우승 상품을 받지 않는다") {
            // given
            val wonMatchedCount = 3
            val wonPrize = Money(3000)
            val lottoPrizePolicy = LottoPrizePolicy(wonMatchedCount, wonPrize, true)
            val wonLottoTicket = LottoTicket.ofInts(listOf(1, 2, 3, 10, 20, 30))
            val winningLottoNumbers = WinningLottoNumbers(LottoTicketNumbers.ofInts(listOf(1, 2, 3, 4, 5, 6)), LottoTicketNumber(7))

            // when
            val prize =
                lottoPrizePolicy.won(wonLottoTicket, winningLottoNumbers)

            // then
            prize shouldBe null
        }
    }

    describe("같은 정책인지 확인할수 있다") {
        forAll(
            row(
                "당첨번호 횟수가 일치하지 않은 경우",
                LottoPrizePolicy(3, Money(1000)),
                LottoPrizePolicy(4, Money(1000))
            ),
            row(
                "당첨번호 횟수가 일치 하지만 보너스 볼 포함 여부가 다른 경우",
                LottoPrizePolicy(3, Money(1000), true),
                LottoPrizePolicy(3, Money(1000), false)
            )
        ) { label, aPolicy, bPolicy ->
            it("$label 서로 다른 정책으로 본다") {
                // then
                (aPolicy == bPolicy) shouldBe false
            }
        }

        forAll(
            row(
                "당첨번호 횟수가 일치하는 경우",
                LottoPrizePolicy(3, Money(1000)),
                LottoPrizePolicy(3, Money(1000))
            ),
            row(
                "당첨번호 횟수, 보너스 볼 포함 여부가 일치하는 경우",
                LottoPrizePolicy(3, Money(1000), true),
                LottoPrizePolicy(3, Money(1000), true)
            ),
            row(
                "한쪽만 보너스 볼 포함을 설정하고 당첨번호 횟수 일치 경우",
                LottoPrizePolicy(3, Money(1000), true),
                LottoPrizePolicy(3, Money(1000))
            ),
        ) { label, aPolicy, bPolicy ->
            it("$label 서로 같은 정책으로 본다") {
                // then
                (aPolicy == bPolicy) shouldBe true
            }
        }
    }
})
