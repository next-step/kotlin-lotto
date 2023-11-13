package lotto.model

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec

class PurchaseGamesTest : StringSpec({

    "총 구매 수량보다 수동 구매 수량이 많게 입력되면 IllegalArgumentException throw" {
        shouldThrow<IllegalArgumentException> {
            PurchaseGames(1, 2, "1,2,3,4,5,6\n7,8,9,10,11,12")
        }
    }

    "발권이 불가능한 문자열이 입력되면 IllegalArgumentException throw 해야한다" {
        shouldThrow<IllegalArgumentException> {
            println("숫자가 5개라서 실패")
            PurchaseGames(3, 1, "1,2,3,4,5")
        }
        shouldThrow<IllegalArgumentException> {
            println("숫자가 7개라서 실패")
            PurchaseGames(3, 1, "1,2,3,4,5,6,7")
        }
    }

})
