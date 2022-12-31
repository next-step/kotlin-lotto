package com.nextstep.lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage

class LottoStatTest : BehaviorSpec({

    Given("당첨 로또와 일치하는 숫자인 숫자 리스트가 주어지고") {
        val numbers = listOf(1, 3, 3, 5, 4, 0, 1)

        When("LottoStat 을 생성하면") {
            val lottoStat = LottoStat(numbers)

            Then("맞춘 숫자에 해당하는 티켓의 개수를 알 수 있다.") {
                lottoStat.lottoCountOf(0) shouldBe 1
                lottoStat.lottoCountOf(1) shouldBe 2
                lottoStat.lottoCountOf(2) shouldBe 0
                lottoStat.lottoCountOf(3) shouldBe 2
                lottoStat.lottoCountOf(4) shouldBe 1
                lottoStat.lottoCountOf(5) shouldBe 1
                lottoStat.lottoCountOf(6) shouldBe 0
            }

            Then("LottoStat에 0보다 작거나, 6보다 큰 수 만큼 일치하는 티켓의 개수를 요청하면 Exception이 발생한다.") {
                forAll(
                    row(-1),
                    row(7)
                ) { rank ->
                        shouldThrow<IllegalArgumentException> {
                            lottoStat.lottoCountOf(rank)
                        } shouldHaveMessage "일치하는 숫자의 개수는 0에서 6사이 입니다. rank: $rank"
                }
            }

            Then("수익율을 구할 수 있다.") {
                val profitRate = lottoStat.profitRate()
                profitRate shouldBe 222.86
            }
        }
    }
})
