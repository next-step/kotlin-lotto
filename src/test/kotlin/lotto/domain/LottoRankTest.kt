package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.data.Headers2
import io.kotest.data.Headers4
import io.kotest.data.Row2
import io.kotest.data.Row4
import io.kotest.data.Table2
import io.kotest.data.Table4
import io.kotest.data.forAll
import io.kotest.matchers.shouldBe

class LottoRankTest : DescribeSpec({
    describe("일치하는 숫자만 보는 로또 등급 케이스") {
        forAll(
            Table2(
                Headers2("등", "일치 번호"),
                listOf(
                    Row2("ONE", 6),
                    Row2("THIRD", 4),
                    Row2("FOURTH", 3),
                ),
            )
        ) { rankName, lottoNumberMatchCount ->
            it("${rankName}은 ${lottoNumberMatchCount}개의 번호가 일치하면 당첨이다") {
                // given
                val targetRank = LottoRank.valueOf(rankName)
                val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
                val testLottoNumbers: MutableList<Int> = mutableListOf()
                testLottoNumbers.addAll(winningNumbers.take(lottoNumberMatchCount))
                for (i: Int in testLottoNumbers.size + 1..LottoTicketNumbers.LOTTO_TICKET_NUMBER_SIZE)
                    testLottoNumbers.add(i + 10)

                // when
                val lottoTicket = LottoTicket.ofInts(testLottoNumbers)
                val winningLottoNumbers = WinningLottoNumbers(
                    LottoTicketNumbers.ofInts(winningNumbers),
                    LottoTicketNumber(7)
                )
                val won = targetRank.isWon(lottoTicket, winningLottoNumbers)

                // then
                won shouldBe true
            }
        }
    }

    describe("일치하는 숫자, 보너스 볼까지 보는 로또 등급 케이스") {
        forAll(
            Table4(
                Headers4("등", "일치 번호", "보너스 볼 포함 여부", "보너스볼 라벨"),
                listOf(
                    Row4("TWO", 5, true, "포함"),
                    Row4("THREE", 5, false, "미포함"),
                ),
            )
        ) { rankName, lottoNumberMatchCount, hasBonusBall, bonuseBallLabel ->
            it("${rankName}은 ${lottoNumberMatchCount}개의 번호가 일치하고 보너슬 볼을 $bonuseBallLabel 한 경우 당첨이다") {
                // given
                val targetRank = LottoRank.valueOf(rankName)
                val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
                val bonusNumber = 30
                val testLottoNumbers: MutableList<Int> = mutableListOf()
                if (hasBonusBall) {
                    testLottoNumbers.add(bonusNumber)
                }
                testLottoNumbers.addAll(winningNumbers.take(lottoNumberMatchCount))
                for (i: Int in testLottoNumbers.size + 1..LottoTicketNumbers.LOTTO_TICKET_NUMBER_SIZE)
                    testLottoNumbers.add(i + 10)

                // when
                val lottoTicket = LottoTicket.ofInts(testLottoNumbers)
                val winningLottoNumbers = WinningLottoNumbers(
                    LottoTicketNumbers.ofInts(winningNumbers),
                    LottoTicketNumber(bonusNumber)
                )
                val won = targetRank.isWon(lottoTicket, winningLottoNumbers)

                // then
                won shouldBe true
            }
        }
    }
})
