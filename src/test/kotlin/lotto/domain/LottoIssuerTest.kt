package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class LottoIssuerTest : BehaviorSpec({

    given("1번부터 순차적으로 발행하는 발급 전략이 주어졌을 때") {
        val ticketAmount = Amount(1000)
        val lottoIssuer = LottoIssuer(ticketAmount, FakeIssueStrategy)

        `when`("로또를 발급하면") {
            val purchaseAmount = Amount(1000)
            val lotto = lottoIssuer.issue(purchaseAmount)

            then("1,2,3,4,5,6 로또가 발급된다.") {
                lotto.lottos.size shouldBe 1
                lotto.lottos[0].numbers.mapIndexed { index, lottoNumber ->
                    lottoNumber shouldBe LottoNumber(index + 1)
                }
            }
        }
    }

    given("티켓 1장 가격이 1000원일 때") {
        val ticketAmount = Amount(1000)
        val lottoIssuer = LottoIssuer(ticketAmount, FakeIssueStrategy)

        `when`("1000원 미만 금액을 입력하면") {
            val purchaseAmount = Amount(999)

            then("예외가 발생한다.") {
                shouldThrow<IllegalArgumentException> {
                    lottoIssuer.issue(purchaseAmount)
                }
            }
        }

        `when`("1000원을 입력하면") {
            val purchaseAmount = Amount(1000)

            then("로또 1장이 발급된다.") {
                val numbers = lottoIssuer.issue(purchaseAmount)
                numbers.lottos.size shouldBe 1
            }
        }

        `when`("2000원을 입력하면") {
            val purchaseAmount = Amount(2000)

            then("로또 2장이 발급된다.") {
                val numbers = lottoIssuer.issue(purchaseAmount)
                numbers.lottos.size shouldBe 2
            }
        }
    }
})
