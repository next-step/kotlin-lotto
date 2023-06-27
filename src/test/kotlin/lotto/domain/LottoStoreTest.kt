package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class LottoStoreTest : BehaviorSpec({
    given("로또(자동)를 구매할 때") {
        `when`("구매 금액이 0이면") {
            val fee = 0
            then("로또 구매 장수는 0이다.") { LottoStore.auto(fee).size shouldBe 0 }
        }
        `when`("구매 금액이 로또 가격의 배수가 아니면") {
            val fee = 1500
            then("에러가 발생 한다.") { shouldThrow<RuntimeException> { LottoStore.auto(fee) } }
        }
        `when`("구매 금액이 로또 가격의 배수이면") {
            val fee = 1000
            then("정상적으로 구매 된다.") { LottoStore.auto(fee).size shouldBe 1 }
        }
    }

    given("로또(수동)를 구매할 때") {
        `when`("숫자가 중복 없이 6개이면") {
            val numbers = listOf(1, 2, 3, 4, 5, 6)
            then("정상적으로 구매 된다.") {
                LottoStore.manual(numbers)
            }
        }
        `when`("숫자가 6개 보다 적으면") {
            val numbers = listOf(1, 2, 3, 4, 5)
            then("에러가 발생 한다.") {
                shouldThrow<RuntimeException> { LottoStore.manual(numbers) }
            }
        }
        `when`("숫자가 6개 보다 많으면 ") {
            val numbers = listOf(1, 2, 3, 4, 5, 6, 7)
            then("에러가 발생 한다.") {
                shouldThrow<RuntimeException> { LottoStore.manual(numbers) }
            }
        }
        `when`("6개 이지만 중복이 존재하면") {
            val numbers = listOf(1, 2, 3, 4, 6, 6)
            then("에러가 발생 한다.") {
                shouldThrow<RuntimeException> { LottoStore.manual(numbers) }
            }
        }
    }
})
