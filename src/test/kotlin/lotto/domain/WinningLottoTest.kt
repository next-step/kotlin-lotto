package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class WinningLottoTest : FunSpec({
    context("당첨 로또 번호는 6개이고 보너스 번호는 1개입니다.") {
        val winningLotto = WinningLotto(createSimpleLottoNumbers(), 7)
        winningLotto.numbers.size shouldBe 6
        winningLotto.bonusNumber shouldBe 7
    }
})
