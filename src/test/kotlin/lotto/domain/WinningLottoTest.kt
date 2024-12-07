package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class WinningLottoTest : FreeSpec({
    "WinningLotto를 만들 때, 보너스 번호가 로또 번호 목록에 중복 존재할 경우 예외를 발생시킨다" {
        val lotto = Lotto(1, 2, 3, 4, 5, 6)
        val bonusNumber = LottoNumber(3)

        shouldThrow<WinningLottoBonusNumberDuplicationException> { WinningLotto(lotto, bonusNumber) }
    }
})
