package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import lotto.domain.model.Lottos

class LottosTest : StringSpec({
    "로또들이 비어 있을 경우 IllegalArgumentException 예외를 던진다." {
        shouldThrow<IllegalArgumentException> {
            Lottos.from(emptyList())
        }
    }
})
