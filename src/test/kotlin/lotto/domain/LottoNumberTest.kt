package lotto.domain

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import lotto.exception.InvalidLottoNumberException

class LottoNumberTest : FunSpec({

    test("로또 숫자는 새로운 인스턴스를 생성하지 않는다.") {
        val lottoNumber1 = LottoNumber.of(1)
        val lottoNumber2 = LottoNumber.of(1)

        // Value Class 는 레퍼런스 비교가 안됨
        // (lottoNumber1 === lottoNumber2) shouldBe true
        (lottoNumber1 == lottoNumber2) shouldBe true
    }

    test("로또 숫자는 1부터 45 사이의 숫자입니다.") {
        shouldNotThrow<InvalidLottoNumberException> {
            (1..4).forEach { LottoNumber.of(it) }
        }
        shouldThrow<InvalidLottoNumberException> {
            LottoNumber.of(-1)
        }
        shouldThrow<InvalidLottoNumberException> {
            LottoNumber.of(0)
        }
        shouldThrow<InvalidLottoNumberException> {
            LottoNumber.of(46)
        }
    }
})
