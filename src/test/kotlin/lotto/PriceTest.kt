package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import lotto.domain.model.vo.Price

/**
 * 로또 가격 테스트
 * */
class PriceTest: FunSpec({
    test("로또 가격 생성시 `0`을 넣을 경우 예외(IllegalArgumentException)를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            Price.valueOf(0)
        }
    }

    test("로또 가격 생성시 `900`을 넣을 경우 예외(IllegalArgumentException)를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            Price.valueOf(900)
        }
    }

    test("로또 가격 생성시 `4000`을 넣을 경우 예외(IllegalArgumentException)를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            Price.valueOf(4000)
        }
    }

    test("로또 가격 생성시 `2300`을 넣을 경우 예외(IllegalArgumentException)를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            Price.valueOf(2300)
        }
    }

    test("로또 가격 생성시 `2001`을 넣을 경우 예외(IllegalArgumentException)를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            Price.valueOf(2001)
        }
    }

    test("로또 가격 생성시 `2000`을 넣을 경우 `2000`원을 가진 로또 가격이 생성된다.") {
        Price.valueOf(2000).price shouldBe 2000
    }

    test("로또 가격 생성시 `1000`을 넣을 경우 `1000`원을 가진 로또 가격이 생성된다.") {
        Price.valueOf(1000).price shouldBe 1000
    }

})