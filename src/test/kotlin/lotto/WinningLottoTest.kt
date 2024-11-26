package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.WinningLotto

class WinningLottoTest : StringSpec({
    "일치하는 로또번호의 개수를 확인할 수 있다." {
        val lotto = Lotto(FixedNumberGenerator().generate().map { LottoNumber(it) }.toSet())
        val bonusNumber = LottoNumber(7)

        val winningLotto = WinningLotto(lotto, bonusNumber)

        winningLotto.countMatchingNumbers(lotto) shouldBe 6
    }

    "보너스 번호의 일치 여부를 확인할 수 있다." {
        val lotto = Lotto(FixedNumberGenerator().generate().map { LottoNumber(it) }.toSet())
        val bonusNumber = LottoNumber(7)

        val winningLotto = WinningLotto(lotto, bonusNumber)

        winningLotto.matchBonusNumber(lotto) shouldBe false
    }
})
