package lotto.util

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import org.assertj.core.api.AbstractAssert
import org.assertj.core.api.Assertions.assertThatThrownBy
import java.lang.IllegalArgumentException

class LottoAssert(actual: List<LottoNumber>) :
    AbstractAssert<LottoAssert, List<LottoNumber>>(actual, LottoAssert::class.java) {

    fun validateSize() {
        assertThatThrownBy {
            // when
            Lotto(actual)

            // then
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Invalid Lotto Numbers Size : ${actual.size} should be 6")
    }

    fun validateDuplication() {
        assertThatThrownBy {
            // when
            Lotto(actual)

            // then
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Lotto Numbers Duplication : 1 occurred")
    }
}
