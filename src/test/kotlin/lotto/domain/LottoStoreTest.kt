package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class LottoStoreTest : BehaviorSpec({
    given("로또를 구매할 때") {
        `when`("구매 금액이 0이면") {
            val fee = 0
            then("로또 구매 장수는 0이다.") { LottoStore.buy(fee).size shouldBe 0 }
        }
        `when`("구매 금액이 로또 가격의 배수가 아니면") {
            val fee = 1500
            then("에러가 발생 한다.") { shouldThrow<RuntimeException> { LottoStore.buy(fee) } }
        }
        `when`("구매 금액이 로또 가격의 배수이면") {
            val fee = 1000
            then("정상적으로 구매 된다.") { LottoStore.buy(fee).size shouldBe 1 }
        }
    }
})
