package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.data.row
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class WinningLottoTest : FunSpec({
    context("당첨 로또 번호는 6개이고 보너스 번호는 1개입니다.") {
        val winningLotto = WinningLotto(LottoNumbers(1, 2, 3, 4, 5, 6), 7)
        winningLotto.numbers.size shouldBe 6
        winningLotto.bonusNumber shouldBe 7
    }

    context("로또의 일치 개수를 확인한다.") {
        withData(
            row(Lotto(1, 2, 3, 4, 5, 6), WinningLotto(LottoNumbers(1, 2, 3, 4, 5, 6), 45), 6),
            row(Lotto(1, 2, 3, 4, 5, 6), WinningLotto(LottoNumbers(1, 2, 3, 4, 5, 7), 45), 5),
            row(Lotto(1, 2, 3, 4, 5, 6), WinningLotto(LottoNumbers(1, 2, 3, 4, 7, 8), 45), 4),
            row(Lotto(1, 2, 3, 4, 5, 6), WinningLotto(LottoNumbers(7, 8, 9, 10, 11, 12), 45), 0),
        ) { (lotto, winningLotto, expectedCount) ->
            val matchCount = winningLotto.countMatch(lotto)
            matchCount shouldBe expectedCount
        }
    }
})
