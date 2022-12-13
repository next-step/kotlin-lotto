package com.nextstep.lotto.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.throwable.shouldHaveMessage

class LottoTest : BehaviorSpec({

    Given("Lotto 를 생성할 때") {
        When("서로 다른 6개의 LottoBall 을 전달받으면") {
            Then("exception 이 발생하지 않고 Lotto 이 생성된다.") {
                val lottoNumbers = listOf(
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(4),
                    LottoNumber(5),
                    LottoNumber(6)
                )
                shouldNotThrowAny{ Lotto(lottoNumbers) }
            }
        }

        When("전달 받은 LottoBall 이 6개가 아니면") {
            Then("IllegalArgumentException 이 발생한다.") {
                forAll(
                    row(listOf(1, 2, 3, 4, 5)),
                    row(listOf(1, 2, 3, 4, 5, 6, 7))
                ) {
                    numbers ->
                    val lottoNumbers = numbers.map { LottoNumber(it) }
                    shouldThrow<IllegalArgumentException> { Lotto(lottoNumbers) } shouldHaveMessage
                            "6개의 LottoBall 을 입력받아야 합니다. size: ${numbers.size}"
                }
            }
        }

        When("전달 받은 LottoBall 중 중복 LottoBall 이 있으면") {
            Then("IllegalArgumentException 이 발생한다.") {
                val lottoNumbers = listOf(1, 1, 2, 3, 4, 5).map { LottoNumber(it) }
                shouldThrow<IllegalArgumentException> { Lotto(lottoNumbers) } shouldHaveMessage
                        "중복된 LottoBall 을 입력받을 수 없습니다. numbers: $lottoNumbers"
            }
        }
    }

    Given("Lotto#getNumbers") {
        When("getNumber 를 호출하면") {
            Then("Lotto 가 가지고 있는 LottoBall 의 숫자들을 리턴한다") {
                val lottoNumbers = (1..6).map { LottoNumber(it) }
                val lotto = Lotto(lottoNumbers)
                val numbers = lotto.getNumbers()

                numbers shouldHaveSize 6
                numbers shouldContainExactly ((1..6))
            }
        }
    }
})
