package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.forAll

internal class LottoNumberTest : BehaviorSpec({
    given("로또 번호가") {
        `when`("1 ~ 45 사이의 수가 아닐 때") {
            val numbers = listOf(0, -45, 50, 46, 1111)

            numbers.forAll {
                then("IllegalArgumentException 이 발생한다.") {
                    shouldThrow<IllegalArgumentException> {
                        LottoNumber(it)
                    }
                }
            }
        }
    }
})
