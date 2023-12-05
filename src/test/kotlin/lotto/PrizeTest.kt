package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import lotto.domain.model.Prize

/**
 * 로또 상금 테스트
 * */
class PrizeTest : FunSpec({

    test("로또 상금 생성시 `-100`을 넣을 경우 예외(IllegalArgumentException)를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            Prize.valueOf(-100)
        }
    }

    test("로또 상금 생성시 `-4000`을 넣을 경우 예외(IllegalArgumentException)를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            Prize.valueOf(-4000)
        }
    }

    test("로또 상금 생성시 `-2300000`을 넣을 경우 예외(IllegalArgumentException)를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            Prize.valueOf(-2300000)
        }
    }

    test("로또 상금 생성시 `2000000001`을 넣을 경우 예외(IllegalArgumentException)를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            Prize.valueOf(2000000001)
        }
    }

    test("로또 상금 생성시 `2000000000`을 넣을 경우 `2000000000`원을 가진 로또 상금이 생성된다.") {
        Prize.valueOf(2000000000).value shouldBe 2000000000
    }

    test("로또 상금 생성시 `5000`을 넣을 경우 `5000`원을 가진 로또 상금이 생성된다.") {
        Prize.valueOf(5000).value shouldBe 5000
    }
})
