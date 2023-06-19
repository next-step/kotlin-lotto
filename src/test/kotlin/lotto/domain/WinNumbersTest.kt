package lotto.domain

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.core.spec.style.BehaviorSpec

class WinNumbersTest : BehaviorSpec({

    given("당첨번호가 유효한 범위의 숫자가 주어졌다") {
        val winLotto =
            Lotto((LottoNumber.LOTTO_MIN_NUMBER until LottoNumber.LOTTO_MIN_NUMBER + Lotto.LOTTO_NUMBER_SIZE).toSet())
        val bonusNumber = LottoNumber.LOTTO_MIN_NUMBER + Lotto.LOTTO_NUMBER_SIZE
        `when`("당첨번호를 생성하면") {
            then("예외가 던져지지 않는다") {
                shouldNotThrow<Throwable> { WinNumbers(winLotto, bonusNumber) }
            }
        }
    }
})
