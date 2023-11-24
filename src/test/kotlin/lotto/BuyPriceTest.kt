package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import lotto.domain.model.vo.BuyPrice


/**
 * 로또 구입 금액 테스트
 * */
class BuyPriceTest : FunSpec({

    test("구입금액에 `0` 입력시 예외(IllegalArgumentException)를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            BuyPrice.valueOf(0)
        }
    }

    test("구입금액에 `900` 입력시 예외(IllegalArgumentException)를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            BuyPrice.valueOf(900)
        }
    }

    test("구입금액에 `1500` 입력시 예외(IllegalArgumentException)를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            BuyPrice.valueOf(1500)
        }
    }

    test("구입금액에 `10001` 입력시 예외(IllegalArgumentException)를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            BuyPrice.valueOf(10001)
        }
    }

    test("구입금액에 `1000` 입력시 구입금액이 `1000`원 이여야한다.") {
        BuyPrice.valueOf(1000).buyPrice shouldBe 1000
    }

    test("구입금액에 `23000` 입력시 구입금액이 `23000`원 이여야한다.") {
        BuyPrice.valueOf(23000).buyPrice shouldBe 23000
    }

})
