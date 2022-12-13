package com.nextstep.lotto.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage

class WinningLottoTest : BehaviorSpec({

    Given("WinningLottoNumbers 를 생성할 때") {
        When("입력 받은 당첨 번호가 6개가 아니면") {
            Then("IllegalArgumentException 이 발생한다.") {
                forAll(
                    row(listOf(1, 2, 3, 4, 5)),
                    row(listOf(1, 2, 3, 4, 5, 6, 7))
                ) { numbers ->
                    shouldThrow<IllegalArgumentException> { WinningLotto(numbers) } shouldHaveMessage
                            "당첨 번호는 6개여야 합니다. size: ${numbers.size}"
                }
            }
        }

        When("입력 받은 당첨 번호에 중복이 있다면") {
            Then("IllegalArgumentException 이 발생한다.") {
                val numbers = listOf(1, 1, 2, 3, 4, 5)
                shouldThrow<IllegalArgumentException> { WinningLotto(numbers) } shouldHaveMessage
                        "당첨 번호에는 중복이 없어야 합니다. numbers: $numbers"
            }
        }

        When("서로 다른 6개의 당첨 번호가 입력되면") {
            Then("exception 발생 없이 WinningLottoNumbers 가 생성된다.") {
                val numbers = listOf(1, 2, 3, 4, 5, 6)
                shouldNotThrowAny { WinningLotto(numbers) }
            }
        }
    }
})
