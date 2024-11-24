package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoTest : StringSpec({

    "로또를 생성한다." {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        lotto shouldBe Lotto(listOf(1, 2, 3, 4, 5, 6))
    }

    "로또 번호가 6개 미만이라면 예외를 던진다." {
        shouldThrow<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5))
        }
    }

    "로또 번호가 하나라도 1 미만 이라면 예외를 던진다." {
        shouldThrow<IllegalArgumentException> {
            Lotto(listOf(0, 1, 2, 3, 4, 5))
        }
    }

    "로또 번호가 하나라도 45 초과라면 예외를 던진다." {
        shouldThrow<IllegalArgumentException> {
            Lotto(listOf(41, 42, 43, 44, 45, 46))
        }
    }
})
