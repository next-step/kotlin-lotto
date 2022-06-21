package lotto.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec

class LottoAmountTest : StringSpec({
    "로또 갯수로 음수를 입력받으면 예외를 발생시킨다." {
        // given
        val amountOfAutoLotto = 1
        val invalidAmountOfManualLotto = -1

        // when // then
        shouldThrowExactly<IllegalArgumentException> { LottoAmount(amountOfAutoLotto, invalidAmountOfManualLotto) }
    }
})
