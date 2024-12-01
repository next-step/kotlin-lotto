package lotto

import io.kotest.assertions.assertSoftly
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.domain.Lotto
import lotto.domain.LottoNumber

class LottoTest : StringSpec({
    "한장의 로또는 6개의 숫자로 구성된다." {

        val lotto = createLotto(1, 2, 3, 4, 5, 6)

        lotto.numbers.size shouldBe 6
    }

    "한장의 로또는 6개 미만 혹은 6개 초과된 숫자가 전달될 경우 예외를 반환한다." {
        assertSoftly {
            shouldThrow<IllegalArgumentException> { Lotto(setOf()) }
            shouldThrow<IllegalArgumentException> { Lotto(setOf(LottoNumber.getNumber(1))) }
            shouldThrow<IllegalArgumentException> { Lotto((1..7).map { LottoNumber.getNumber(it) }.toSet()) }
        }
    }
})
