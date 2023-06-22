package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class WinningLottoTest : StringSpec({

    "보너스 넘버가 로또 번호에 포함될 경우 예외가 발생한다" {
        shouldThrow<IllegalArgumentException> {
            WinningLotto(
                lotto = Lotto(listOf(1, 2, 3, 4, 5, 6)),
                bonusNumber = 6
            )
        }.message shouldBe "보너스 넘버는 로또당첨번호에 포함되면 안됩니다."
    }
})
