package lotto.domain

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec

class WinNumbersTest : BehaviorSpec({
    given("당첨번호가 ${Lotto.LOTTO_NUMBER_SIZE}개가 주어지지 않았다") {
        val winNumber =
            (LottoNumber.LOTTO_MIN_NUMBER until LottoNumber.LOTTO_MIN_NUMBER + Lotto.LOTTO_NUMBER_SIZE - 1).toList()
        `when`("당첨번호를 생성하면") {
            then("예외가 던져진다") {
                shouldThrow<IllegalArgumentException> { WinNumbers(winNumber) }
            }
        }
    }

    given("당첨번호가 유효한 범위의 숫자가 주어졌다") {
        val winNumber =
            (LottoNumber.LOTTO_MIN_NUMBER until LottoNumber.LOTTO_MIN_NUMBER + Lotto.LOTTO_NUMBER_SIZE).toList()
        `when`("당첨번호를 생성하면") {
            then("예외가 던져지지 않는다") {
                shouldNotThrow<Throwable> { WinNumbers(winNumber) }
            }
        }
    }
})
