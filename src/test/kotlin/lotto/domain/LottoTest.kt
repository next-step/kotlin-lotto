package lotto.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LottoTest : BehaviorSpec({

    Given("고객이 존재하고") {
        val customer = Customer("5000")
        When("로또 상점이 로또 구매 요청을 한다면") {
            val lotto = LottoShop().buyLotto(customer)
            Then("금액 천원 단위 만큼 로또를 반환한다.") {
                lotto.lines.size shouldBe 5
            }
            Then("각 라인에는 6개의 숫자가 존재한다.") {
                lotto.lines.all { it.size == 6 }
            }
            Then("각 라인의 숫자는 정렬되어 있다.") {
                fun isSorted(list: List<Int>): Boolean {
                    for(index in 0 until list.size - 1) {
                        if (list[index] > list[index + 1]) return false
                    }
                    return true
                }
                lotto.lines.all { isSorted(it) }
            }
        }
    }
})
