package lotto.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class LottoTest : BehaviorSpec({

    Given("고객이 존재하고") {
        val customer = Customer.of("5000")
        When("로또 상점에게 로또 구매 요청을 한다면") {
            val lotto = LottoShop().buyLotto(customer)
            Then("금액 천원 단위 만큼 로또를 반환한다.") {
                lotto.lines.size shouldBe 5
            }
            Then("각 라인에는 6개의 숫자가 존재한다.") {
                lotto.lines.all { it.size == 6 }
            }
            Then("각 라인의 숫자는 정렬되어 있다.") {
                fun isSorted(list: List<Int>): Boolean {
                    for (index in 0 until list.size - 1) {
                        if (list[index] > list[index + 1]) return false
                    }
                    return true
                }
                lotto.lines.all { isSorted(it) }
            }
        }
    }

    Given("로또에 추첨 번호가 주어지면") {
        val lotto = Lotto(
            listOf(
                listOf(1, 2, 3, 4, 5, 6),
                listOf(1, 2, 3, 4, 5, 7),
                listOf(1, 2, 3, 4, 7, 8),
                listOf(1, 2, 3, 7, 8, 9),
            )
        )
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        Then("각 라인별 동일한 번호의 개수 리스트를 반환한다.") {
            val sameNumberCount = lotto.getAllSameNumberCount(winningNumbers)
            sameNumberCount.size shouldBe 4
            sameNumberCount shouldBe listOf(6, 5, 4, 3)
        }
    }
})
