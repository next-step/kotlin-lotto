package lotto.model

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class LottoWinningTest : BehaviorSpec({
    Given("1,2,3,4,5,6 당첨번호") {

        val numbers = "1,2,3,4,5,6".toNumbers()
        val bonus = 10
        val lottoWinning = LottoWinning(numbers, bonus = bonus)
        When("나의 로또 번호 1,2,3,7,8,9") {
            val lotto = Lotto.createWinning("1,2,3,7,8,9".toNumbers())
            Then("3개 일치 이다") {
                val result = lottoWinning.lottoResult(listOf(lotto)).toList()
                val prize = result[0].first
                prize shouldBe Rank.FIFTH
            }
        }

        When("나의 로또 번호 1,2,3,4,8,9") {
            val lotto = Lotto.createWinning("1,2,3,4,8,9".toNumbers())
            Then("4개 일치 이다") {
                val result = lottoWinning.lottoResult(listOf(lotto)).toList()
                val prize = result[0].first
                prize shouldBe Rank.FOURTH
            }
        }

        When("나의 로또 번호 1,2,3,4,5,6") {
            val lotto = Lotto.createWinning("1,2,3,4,5,6".toNumbers())
            Then("6개 일치 이다") {
                val result = lottoWinning.lottoResult(listOf(lotto)).toList()
                val prize = result[0].first
                prize shouldBe Rank.FIRST
            }
        }

        When("나의 로또 번호 1,2,3,4,5,7") {
            val lotto = Lotto.createWinning("1,2,3,4,5,7".toNumbers())
            Then("5개 일치 이다") {
                val result = lottoWinning.lottoResult(listOf(lotto)).toList()
                val prize = result[0].first
                prize shouldBe Rank.THIRD
            }
        }

        When("나의 로또 번호 1,2,3,4,5,10") {
            val lotto = Lotto.createWinning("1,2,3,4,5,10".toNumbers())
            Then("5개 일치 이다 보너스 일치") {
                val result = lottoWinning.lottoResult(listOf(lotto)).toList()
                val prize = result[0].first
                prize shouldBe Rank.SECOND
            }
        }

        When("나의 로또 번호 2,3,4,5,6,10") {
            val lotto = Lotto.createWinning("2,3,4,5,6,10".toNumbers())
            Then("5개 일치 이다 보너스 일치") {
                val result = lottoWinning.lottoResult(listOf(lotto)).toList()
                val prize = result[0].first
                prize shouldBe Rank.SECOND
            }
        }

        When("로또 번호 14개의 중 3개 일치 1개") {
            val lottoList = mutableListOf<Lotto>().apply {
                repeat(13) {
                    add(Lotto.createWinning("11,12,13,14,15,16".toNumbers()))
                }
                add(Lotto.createWinning("1,2,3,7,8,9".toNumbers()))
            }
            Then("구매금액 14000 수익률 0.35") {
                val amount = 14000
                val result = lottoWinning.lottoResult(lottoList)
                val total = LottoStatistics.totalStatistics(result, amount)

                println(" total $total")
                total.toDecimalPoint() shouldBe "0.35"
            }
        }
    }
})

fun String.toNumbers() = this.split(",").map { it.toInt() }
