package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.ExpectSpec
import io.kotest.data.forAll
import io.kotest.data.row

class AmountTest : ExpectSpec({

    expect("0보다 작은 수를 입력하면 예외가 발생한다.") {
        shouldThrow<IllegalArgumentException> {
            Amount(-1) + Amount(-1)
        }
    }

    expect("금액을 나눈 몫을 구할 때 나머지가 0이 아니면 예외가 발생한다.") {
        forAll(
            row(Amount(1_000), Amount(1_001)),
            row(Amount(1_000), Amount(999)),
        ) { amount1, amount2 ->
            shouldThrow<IllegalArgumentException> {
                amount1.divide(amount2)
            }
        }
    }
})
