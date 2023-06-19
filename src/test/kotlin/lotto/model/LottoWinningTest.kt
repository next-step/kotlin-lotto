package lotto.model

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class LottoWinningTest : BehaviorSpec({
    Given("1,2,3,4,5,6 당첨번호") {
        val lottoWinning = LottoWinning("1,2,3,4,5,6")
        When("나의 로또 번호 1,2,3,7,8,9") {
            val lotto = Lotto.createWinning("1,2,3,7,8,9")
            Then("3개 일치 이다") {
                val result = lottoWinning.lottoResult(listOf(lotto)).toList()
                val prize = result[0].first
                prize shouldBe LottoPrize.FOURTH
            }
        }

        When("나의 로또 번호 1,2,3,4,8,9") {
            val lotto = Lotto.createWinning("1,2,3,4,8,9")
            Then("4개 일치 이다") {
                val result = lottoWinning.lottoResult(listOf(lotto)).toList()
                val prize = result[0].first
                prize shouldBe LottoPrize.THIRD
            }
        }

        When("나의 로또 번호 1,2,3,4,5,6") {
            val lotto = Lotto.createWinning("1,2,3,4,5,6")
            Then("6개 일치 이다") {
                val result = lottoWinning.lottoResult(listOf(lotto)).toList()
                val prize = result[0].first
                prize shouldBe LottoPrize.FIRST
            }
        }

        When("로또 번호 14개의 중 3개 일치 1개") {
            val lottoList = mutableListOf<Lotto>().apply {
                repeat(13) {
                    add(Lotto.createWinning("11,12,13,14,15,16"))
                }
                add(Lotto.createWinning("1,2,3,7,8,9"))
            }
            Then("구매금액 14000 수익률 0.35") {
                val amount = 14000
                val result = lottoWinning.lottoResult(lottoList)
                val total = lottoWinning.totalStatistics(result, amount)

                println(" total $total")
                total.toDecimalPoint() shouldBe "0.35"
            }
        }
    }
})
