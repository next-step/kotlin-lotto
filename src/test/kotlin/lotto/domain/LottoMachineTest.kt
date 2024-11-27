package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class LottoMachineTest : StringSpec({
    "티켓 수 만큼 로또를 생성한다" {
        listOf(1, 2, 3, 4, 5).forAll { count ->
            LottoMachine.purchase(List(count) { Ticket }).size shouldBe count
        }
    }
})
