package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import lotto.domain.model.vo.LottoNumber

/**
 * 로또 번호 테스트
 * */
class LottoNumberTest : FunSpec({

    test("로또 번호 생성시 `-1` 을 넣을 경우 예외(IllegalArgumentException)를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            LottoNumber.valueOf(-1)
        }
    }

    test("로또 번호 생성시 `0`을 넣을 경우 예외(IllegalArgumentException)를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            LottoNumber.valueOf(0)
        }
    }

    test("로또 번호 생성시 `46`을 넣을 경우 예외(IllegalArgumentException)를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            LottoNumber.valueOf(46)
        }
    }

    test("로또 번호 생성시 `6`을 넣을 경우 `6`을 가지고 있는 로또 번호 생성 되어야 한다.") {
        val lottoNumber = LottoNumber.valueOf(6)
        lottoNumber.value shouldBe 6
    }

    test("로또 번호 생성시 `1`을 넣을 경우 `1`을 가지고 있는 로또 번호 생성 되어야 한다.") {
        val lottoNumber = LottoNumber.valueOf(1)
        lottoNumber.value shouldBe 1
    }

    test("로또 번호 생성시 `45`을 넣을 경우 `45`을 가지고 있는 로또 번호 생성 되어야 한다.") {
        val lottoNumber = LottoNumber.valueOf(45)
        lottoNumber.value shouldBe 45
    }
})
