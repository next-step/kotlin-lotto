package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import lotto.constants.WinningRank
import lotto.domain.Lotto.Companion.LOTTO_NUMBER_SIZE
import lotto.domain.LottoStore.takeShuffleNumber

class LottosTest : FunSpec({

    test("당첨번호와 로또번호를 비교하여 당첨 결과를 확인할 수 있다.") {
        val autoLottoList = List(3) { Lotto(takeShuffleNumber(LOTTO_NUMBER_SIZE)) }
        val manualLottoList = List(2) { Lotto(LottoNumbers(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) })) }
        val lottos = Lottos(autoLottoList, manualLottoList)
        val winningNumber = LottoStore.takeShuffleNumber(7)
        val bonusBall = winningNumber.numbers.last()
        val winningLottoNumber = LottoNumbers(winningNumber.numbers.take(6))
        val winningLotto = WinningLotto(winningLottoNumber, bonusBall)
        val winningResult = lottos.matchLotto(winningLotto)
        winningResult.forEach(
            fun(winningRank: WinningRank) {
                (WinningRank.FIRST.name..WinningRank.MISS.name).contains(winningRank.name) shouldBe true
            }
        )
    }
})
