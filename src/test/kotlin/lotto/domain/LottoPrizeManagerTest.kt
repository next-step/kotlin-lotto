package lotto.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage

class LottoPrizeManagerTest : DescribeSpec({

    it("담청 정책을 추가 할 수 있다") {
        // given
        val lottoPrizeManager = LottoPrizeManager()
        val addPrizePolicy = LottoPrizePolicy(3, Money(10000))

        // when
        lottoPrizeManager.addUniquePolicy(addPrizePolicy)

        // then
        lottoPrizeManager.polices[0].winningNumberMatchCount shouldBe addPrizePolicy.winningNumberMatchCount
    }

    it("당첨 통계를 알수 있습니다") {
        // given
        val lottoPrizeManager = LottoPrizeManager()
        lottoPrizeManager.addUniquePolicy(LottoPrizePolicy(6, Money(60000)))
        lottoPrizeManager.addUniquePolicy(LottoPrizePolicy(3, Money(30000)))
        val allMatchedWinningLottoInts = listOf(1, 2, 3, 4, 5, 6)
        val threeMatchedWinningLottoInts = mutableListOf(21, 22, 23)
        threeMatchedWinningLottoInts.addAll(allMatchedWinningLottoInts.take(3))
        val winningLottoNumbers = WinningLottoNumbers.ofInt(allMatchedWinningLottoInts, 7)
        val lottoTickets: List<LottoTicket> = listOf<LottoTicket>(
            LottoTicket.ofInts(allMatchedWinningLottoInts),
            LottoTicket.ofInts(allMatchedWinningLottoInts),
            LottoTicket.ofInts(allMatchedWinningLottoInts),
            LottoTicket.ofInts(threeMatchedWinningLottoInts),
            LottoTicket.ofInts(threeMatchedWinningLottoInts),
            LottoTicket.ofInts(listOf(1, 2, 20, 21, 22, 23)),
        )

        // when
        val winningStats = lottoPrizeManager.getWinningStats(lottoTickets, winningLottoNumbers)

        // then
        // 6개 번호 일치한 당첨 정책 확인
        winningStats[0].lottoPrizePolicy.winningNumberMatchCount shouldBe 6
        winningStats[0].lottoPrizePolicy.wonPrize shouldBe Money(60000)
        winningStats[0].totalWinningCount shouldBe 3
        winningStats[0].totalWinningPrize shouldBe Money(3 * 60000)

        // 3개 일치한 당첨 정책 확인
        winningStats[1].lottoPrizePolicy.winningNumberMatchCount shouldBe 3
        winningStats[1].lottoPrizePolicy.wonPrize shouldBe Money(30000)
        winningStats[1].totalWinningCount shouldBe 2
        winningStats[1].totalWinningPrize shouldBe Money(2 * 30000)
    }

    describe("validate") {
        it("중복된 당첨 정책을 추가한 경우 에러 발생") {
            // given
            val lottoPrizeManager = LottoPrizeManager()
            val addPrizePolicy = LottoPrizePolicy(3, Money(10000))
            val duplicatedPolicy = LottoPrizePolicy(3, Money(10000))

            // then
            shouldThrowExactly<IllegalArgumentException> {
                lottoPrizeManager.addUniquePolicy(addPrizePolicy)
                lottoPrizeManager.addUniquePolicy(duplicatedPolicy)
            }.shouldHaveMessage("동일한 당첨 정책이 존재합니다")
        }
    }
})
