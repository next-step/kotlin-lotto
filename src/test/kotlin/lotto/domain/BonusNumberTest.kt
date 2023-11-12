package lotto.domain

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec

class BonusNumberTest : FunSpec({
    test("보너스 번호는 1부터 45 사이의 숫자다.") {
        shouldNotThrow<Exception> { BonusNumber(15) }
    }

    test("보너스 번호가 1부터 45 사이의 숫자가 아니라면 예외가 발생한다.") {
        shouldThrow<RuntimeException> { BonusNumber(50) }
    }
})
