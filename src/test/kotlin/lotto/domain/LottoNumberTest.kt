package lotto.domain

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec

class LottoNumberTest : BehaviorSpec({
    given("로또번호가 ${LottoNumber.LOTTO_MIN_NUMBER}보다 작다") {
        val number = LottoNumber.RAW_LOTTO_MIN_NUMBER - 1
        `when`("로또번호를 생성하면") {
            then("예외가 던져진다") {
                shouldThrow<IllegalArgumentException> { LottoNumber(number) }
            }
        }
    }

    given("로또번호가 ${LottoNumber.LOTTO_MAX_NUMBER}보다 크다") {
        val number = LottoNumber.RAW_LOTTO_MAX_NUMBER + 1
        `when`("로또번호를 생성하면") {
            then("예외가 던져진다") {
                shouldThrow<IllegalArgumentException> { LottoNumber(number) }
            }
        }
    }

    given("로또번호가 유효한 범위의 숫자가 주어졌다") {
        val numbers = LottoNumber.RAW_LOTTO_MIN_NUMBER..LottoNumber.RAW_LOTTO_MAX_NUMBER
        `when`("로또번호를 생성하면") {
            then("예외가 던져지지 않는다") {
                shouldNotThrow<Throwable> { numbers.map { LottoNumber(it) } }
            }
        }
    }
})
