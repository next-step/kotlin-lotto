package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import lotto.domain.model.vo.RateOfReturn


/**
 * 수익률 테스트
 * */
class RateOfReturnTest : FunSpec({
    test("수익률 생성시 `-1.0`을 입력할 경우 예외(IllegalArgumentException)를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            RateOfReturn.valueOf(-1.0)
        }
    }

    test("수익률 생성시 `-10.0`을 입력할 경우 예외(IllegalArgumentException)를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            RateOfReturn.valueOf(-10.0)
        }
    }

    test("수익률 생성시 `100.0` 입력시 `100.0`을 가진 수익률이 생성 되어야한다.") {
        RateOfReturn.valueOf(100.0).value shouldBe 100.0
    }

    test("수익률 생성시 `100000.0` 입력시 `100000.0`을 가진 수익률이 생성 되어야한다.") {
        RateOfReturn.valueOf(100000.0).value shouldBe 100000.0
    }

})
