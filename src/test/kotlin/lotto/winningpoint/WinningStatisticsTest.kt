package lotto.winningpoint

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.maps.shouldHaveSize
import io.kotest.matchers.shouldBe
import lotto.domain.AutoLotto
import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.Lottos
import lotto.domain.ManualLotto
import lotto.domain.WinningLotto

class WinningStatisticsTest : FunSpec({
    test("전달된 로또와 당첨번호를 비교하여 당첨 통계를 계산한다(자동만)") {
        // Given
        val buyPrice = 2000L
        val first = (1..6).map { LottoNumber(it) }
        val nothing = (11..16).map { LottoNumber(it) }
        val autoLotto = AutoLotto(buyPrice, listOf(Lotto(first), Lotto(nothing)))
        val autoLottos = autoLotto.lottos
        val lottos = Lottos(autoLottos)

        val winningLotto = WinningLotto("1,2,3,4,5,6", "7")

        // When
        val statistics = WinningStatistics.calculateStatistics(lottos, winningLotto)

        // Then
        statistics.getValue(WinningRank.FIRST) shouldBe 1
        statistics.getValue(WinningRank.NOTHING) shouldBe 1
        statistics shouldHaveSize 2
    }

    test("전달된 로또와 당첨번호를 비교하여 당첨 통계를 계산한다(자동,수동모두)") {
        // Given
        val first = (1..6).map { LottoNumber(it) }
        val nothing = (11..16).map { LottoNumber(it) }
        val autoLotto = AutoLotto(2000L, listOf(Lotto(first), Lotto(nothing)))
        val autoLottos = autoLotto.lottos
        val manualLotto: ManualLotto = ManualLotto().addLottoNumbers(nothing)
        val lottos = Lottos(autoLottos + manualLotto.lottos)

        val winningLotto = WinningLotto("1,2,3,4,5,6", "7")

        // When
        val statistics = WinningStatistics.calculateStatistics(lottos, winningLotto)

        // Then
        statistics.getValue(WinningRank.FIRST) shouldBe 1
        statistics.getValue(WinningRank.NOTHING) shouldBe 2
        statistics shouldHaveSize 2
    }
})
