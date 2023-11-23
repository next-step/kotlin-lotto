package lotto2.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class WinningLottoTest : StringSpec({

    "당첨 번호와 보너스 번호가 중복되면 예외가 발생한다" {
        shouldThrow<IllegalArgumentException> {
            WinningLotto(
                LottoNumbers(listOf(1, 2, 3, 4, 5, 6).map(::LottoNumber)),
                LottoNumber(6)
            )
        }
    }

    "당첨 번호와 로또 티켓을 비교하여 올바른 등수 목록을 반환한다." {
        val winningNumbers = LottoNumbers(listOf(1, 2, 3, 4, 5, 6).map(::LottoNumber))
        val bonusNumber = LottoNumber(7)
        val winningLotto = WinningLotto(winningNumbers, bonusNumber)
        val lottoTickets = listOf(
            LottoTicket(LottoNumbers(listOf(1, 2, 3, 4, 5, 6).map(::LottoNumber))), // 1등
            LottoTicket(LottoNumbers(listOf(1, 2, 3, 4, 5, 7).map(::LottoNumber))) // 2등
        )

        val rankings = winningLotto.getRankings(lottoTickets)
        val winningStatistics = rankings.getWinningStatistics()

        winningStatistics.get(LottoRanking.FIRST) shouldBe 1
        winningStatistics.get(LottoRanking.SECOND) shouldBe 1
        winningStatistics.get(LottoRanking.THIRD) shouldBe 0
        winningStatistics.get(LottoRanking.FOURTH) shouldBe 0
        winningStatistics.get(LottoRanking.FIFTH) shouldBe 0
        winningStatistics.get(LottoRanking.MISS) shouldBe 0
    }
})
