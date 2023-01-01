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
                    row(intArrayOf(1, 2, 3, 4, 5)),
                    row(intArrayOf(1, 2, 3, 4, 5, 6, 7))
                ) { numbers ->
                    shouldThrow<IllegalArgumentException> { WinningLotto(*numbers) } shouldHaveMessage
                            "당첨 번호는 6개여야 합니다. size: ${numbers.size}"
                }
            }
        }

        When("입력 받은 당첨 번호에 중복이 있다면") {
            Then("IllegalArgumentException 이 발생한다.") {
                val numbers = listOf(1, 1, 2, 3, 4, 5).map(::LottoNumber)
                shouldThrow<IllegalArgumentException> { WinningLotto(numbers) } shouldHaveMessage
                        "당첨 번호에는 중복이 없어야 합니다. numbers: $numbers"
            }
        }

        When("서로 다른 6개의 당첨 번호가 입력되면") {
            Then("exception 발생 없이 WinningLottoNumbers 가 생성된다.") {
                val numbers = intArrayOf(1, 2, 3, 4, 5, 6)
                shouldNotThrowAny { WinningLotto(*numbers) }
            }
        }
    }

    Given("WinningLotto#match") {
        When("Lotto를 받아서") {
            Then("일치하는 숫자의 개수를 리턴한다") {
                forAll(
                    row(intArrayOf(1, 2, 3, 4, 5, 6), 6),
                    row(intArrayOf(1, 2, 3, 4, 5, 7), 5),
                    row(intArrayOf(1, 2, 3, 4, 8, 7), 4),
                    row(intArrayOf(1, 2, 3, 9, 8, 7), 3),
                    row(intArrayOf(1, 2, 10, 9, 8, 7), 2),
                    row(intArrayOf(1, 11, 10, 9, 8, 7), 1),
                    row(intArrayOf(12, 11, 10, 9, 8, 7), 0),
                ) { winningNumbers, matchCount ->
                    val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6).map(::LottoNumber))
                    val winningLotto = WinningLotto(*winningNumbers)
                    winningLotto.match(lotto) shouldBe matchCount
                }
            }
        }
    }
})
