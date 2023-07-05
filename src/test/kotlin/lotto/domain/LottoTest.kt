package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class LottoTest : FunSpec({

    context("로또 번호가 6개가 아니면 오류가 발생합니다.") {
        withData(
            setOf(1, 2, 3, 4, 5) to "로또 번호는 6개여야 합니다.",
            setOf(1, 2, 3, 4, 5, 6, 7) to "로또 번호는 6개여야 합니다.",
        ) { (input, expected) ->
            shouldThrow<IllegalArgumentException> {
                Lotto(LottoNumbers(input))
            }.message shouldBe expected
        }
    }

    context("로또 번호가 1~45 범위가 아니면 오류가 발생합니다.") {
        withData(
            setOf(1, 2, 3, 4, 5, 46) to "로또 번호는 1부터 45 사이여야 합니다.",
            setOf(1, 2, 3, 4, 5, 0) to "로또 번호는 1부터 45 사이여야 합니다.",
        ) { (input, expected) ->
            shouldThrow<IllegalArgumentException> {
                Lotto(input)
            }.message shouldBe expected
        }
    }
})
