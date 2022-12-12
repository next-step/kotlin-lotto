package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row

internal class BuyAmountTest : StringSpec({
    "유효하지 못한 값을 입력하는 경우 예외가 발생한다." {
        forAll(
            row("빈값", ""),
            row("공백", "  "),
            row("숫자가 아닌 값", "a"),
            row("천원 미만의 금액", "-1"),
            row("천원 단위가 아닌 금액", "1001")
        ) { description: String, given: String ->
            shouldThrow<IllegalArgumentException> { BuyAmount.of(given) }
        }
    }
})
