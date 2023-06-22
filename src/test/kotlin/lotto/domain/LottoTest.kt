package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoTest : StringSpec({

    "로또 번호를 입력시 숫자가 6개가 아니면 예외가 발생한다." {
        shouldThrow<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5))
        }.message shouldBe "6개의 숫자가 필요합니다."
    }

    "중복 숫자가 존재하면 예외가 발생한다." {
        shouldThrow<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }.message shouldBe "중복되지 않은 6개의 숫자가 필요합니다."
    }

    "1~45를 입력하지 않으면 예외가 발생한다." {
        shouldThrow<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 55))
        }.message shouldBe "1~45의 수만 가능합니다"
    }
})
