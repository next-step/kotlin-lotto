package lotto.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

internal class LottoVendingMachineTest : BehaviorSpec({
    given("로또 자판기에 구입 금액을 입력했을 때") {
        `when`(" 구매할 수 있는 로또가 있다면") {
            val purchasedCount = listOf(1, 14, 30)
            purchasedCount.forAll {

                then("그만큼의 로또가 발급된다.") {
                    val result = LottoVendingMachine.buy(it).size
                    result shouldBe it
                }
            }
        }
    }

    given("로또 자판기에서는") {
        `when`("랜덤으로 로또 번호를 생성했을 때") {
            val lottoNumbers = LottoVendingMachine.makeRandomLottoNumbers()
            then("중복없는 6개의 숫자를 만든다.") {
                lottoNumbers.distinct().size shouldBe 6
            }
        }
    }
})
