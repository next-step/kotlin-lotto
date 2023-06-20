package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.datatest.withData
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class LottoNumberTest : FreeSpec({

    "1~45 가 아닌 숫자는 가질 수 없다." - {
        withData(
            0, 46, 50, 100
        ) { number ->
            shouldThrow<IllegalArgumentException> { LottoNumber.of(number) }
        }
    }

    "1~45 같은 번호인지 비교할 수 있다." {
        (1..45).toList().forAll {
            LottoNumber.of(it) shouldBe LottoNumber.of(it)
        }
    }
})
