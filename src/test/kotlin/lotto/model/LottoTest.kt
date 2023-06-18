package lotto.model

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoTest : StringSpec({

    "로또 번호는 6개 이다" {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }.toSet())
        lotto.numbers.size shouldBe 6
    }

    "로또 번호는 6개 아니면 예외가 발생한다" {
        shouldThrow<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5).map { LottoNumber(it) }.toSet()).numbers.size
        }
        shouldThrow<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7, 8).map { LottoNumber(it) }.toSet()).numbers.size
        }
    }
})
