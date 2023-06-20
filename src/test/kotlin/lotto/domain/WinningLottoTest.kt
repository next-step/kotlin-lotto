package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class WinningLottoTest : FunSpec({
    test("당첨 로또번호와 보너스 로또번호가 중복되면 예외가 발생한다") {
        val exception = shouldThrow<IllegalArgumentException> {
            WinningLotto(Lotto(1, 2, 3, 7, 8, 10), LottoNumber(1))
        }

        exception.message shouldBe "당첨 로또 번호와 보너스 번호는 중복될 수 없습니다."
    }
})
