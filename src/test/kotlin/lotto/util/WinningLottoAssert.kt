package lotto.util

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.WinningLotto
import org.assertj.core.api.AbstractAssert
import org.assertj.core.api.Assertions.assertThatThrownBy
import java.lang.IllegalArgumentException

class WinningLottoAssert(actual: List<LottoNumber>) :
    AbstractAssert<WinningLottoAssert, List<LottoNumber>>(actual, WinningLottoAssert::class.java) {

    fun containBonus(bonus: LottoNumber) {
        isNotNull
        assertThatThrownBy {
            // given
            val winningNumbers = Lotto(actual)

            // when
            WinningLotto(winningNumbers, bonus)

            // then
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Bonus is Duplicate : $bonus should be unique value")
    }

    fun contain(value: LottoNumber): Boolean {
        isNotNull
        if (actual.contains(value)) {
            return true
        }
        return false
    }
}
