package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec

class LottoTest : StringSpec({

    "로또는 6개의 숫자로 구성되어 있지 않으면 예외를 던진다." {
        shouldThrow<IllegalArgumentException> { FakeLottoGenerator().generate(4) }
    }

    "로또는 중복되지 않은 숫자로 구성되어 있지 않으면 예외를 던진다." {
        shouldThrow<IllegalArgumentException> { FakeLottoGenerator().generate(6) }
    }
})
