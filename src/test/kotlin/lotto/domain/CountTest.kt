package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.data.forAll
import io.kotest.data.row

class CountTest : BehaviorSpec({
    Given("로또 수가 0 보다 작은 수가 들어오면") {
        When("Count는") {
            Then("에러를 발생한다.") {
                forAll(
                    row(-1000),
                    row(-1)
                ) { value ->
                    shouldThrow<IllegalArgumentException> {
                        Count(value)
                    }
                }
            }
        }
    }
})
