package autolotto.winningpoint

import autolotto.vo.AutoLotto
import autolotto.vo.Lotto
import autolotto.vo.LottoNumber
import autolotto.vo.WinningLotto
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.maps.shouldHaveSize
import io.kotest.matchers.shouldBe

class WinningStatisticsTest : FunSpec({
    test("전달된 로또와 당첨번호를 비교하여 당첨 통계를 계산한다") {
        // Given
        val first = (1..6).map { LottoNumber(it) }
        val nothing = (11..16).map { LottoNumber(it) }
        val autoLotto = AutoLotto(2000L, listOf(Lotto(first), Lotto(nothing)))
        val winningLotto = WinningLotto("1,2,3,4,5,6", "7")

        // When
        val statistics = WinningStatistics.calculateStatistics(autoLotto, winningLotto)

        // Then
        statistics.getValue(WinningRank.FIRST) shouldBe 1
        statistics.getValue(WinningRank.NOTHING) shouldBe 1
        statistics shouldHaveSize 2
    }
})
