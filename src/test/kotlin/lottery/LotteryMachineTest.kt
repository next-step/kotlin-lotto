package lottery

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class LotteryMachineTest : StringSpec({
    "원하는 갯수만큼 로또를 생성한다" {
        listOf(1, 2, 3, 4, 5).forAll { count ->
            LotteryMachine.buy(count).size shouldBe count
        }
    }
})
