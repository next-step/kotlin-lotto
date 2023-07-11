package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class WinningLottoTest : FunSpec({
    context("당첨 로또 번호는 6개이고 보너스 번호는 1개입니다.") {
        val winningLotto = WinningLotto(createSimpleLottoNumbers(), LottoNumber.from(7))
        winningLotto.lotto.size shouldBe 6
        winningLotto.bonusNumber shouldBe LottoNumber.from(7)
    }

    context("당첨 로또 번호와 보너스 번호는 중복될 수 없습니다.") {
        shouldThrow<IllegalArgumentException> {
            WinningLotto(createSimpleLottoNumbers(1, 2, 3, 4, 5, 6), LottoNumber.from(6))
        }.message shouldBe "보너스 번호는 당첨 번호와 중복될 수 없습니다."
    }
})
