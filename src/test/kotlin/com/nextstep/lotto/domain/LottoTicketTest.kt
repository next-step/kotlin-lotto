package com.nextstep.lotto.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.throwable.shouldHaveMessage

class LottoTicketTest : BehaviorSpec({

    Given("LottoTicket 을 생성할 때") {
        When("서로 다른 6개의 LottoBall 을 전달받으면") {
            Then("exception 이 발생하지 않고 LottoTicket 이 생성된다.") {
                val lottoBalls = listOf(
                    LottoBall(1),
                    LottoBall(2),
                    LottoBall(3),
                    LottoBall(4),
                    LottoBall(5),
                    LottoBall(6)
                )
                shouldNotThrowAny{ LottoTicket(lottoBalls) }
            }
        }

        When("전달 받은 LottoBall 이 6개가 아니면") {
            Then("IllegalArgumentException 이 발생한다.") {
                forAll(
                    row(listOf(1, 2, 3, 4, 5)),
                    row(listOf(1, 2, 3, 4, 5, 6, 7))
                ) {
                    numbers ->
                    val lottoBalls = numbers.map { LottoBall(it) }
                    shouldThrow<IllegalArgumentException> { LottoTicket(lottoBalls) } shouldHaveMessage
                            "6개의 LottoBall 을 입력받아야 합니다. size: ${numbers.size}"
                }
            }
        }

        When("전달 받은 LottoBall 중 중복 LottoBall 이 있으면") {
            Then("IllegalArgumentException 이 발생한다.") {
                val lottoBalls = listOf(1, 1, 2, 3, 4, 5).map { LottoBall(it) }
                shouldThrow<IllegalArgumentException> { LottoTicket(lottoBalls) } shouldHaveMessage
                        "중복된 LottoBall 을 입력받을 수 없습니다. numbers: $lottoBalls"
            }
        }
    }
})
