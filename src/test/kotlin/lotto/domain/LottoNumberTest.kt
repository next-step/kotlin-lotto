package lotto.domain

import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeSameInstanceAs
import lotto.controller.GeneratorRandomNumbers
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4])
    fun `객체를 비교한다`(value: Int) {
        val lottoNumber = LottoNumber.from(value)
        (lottoNumber == LottoNumber.from(value)) shouldBe true
    }

    @Test
    fun `같은 로또 번호가 동일한 객체로 반환한다`() {
        val lotto1 = LottoNumber.from(1)
        val lotto2 = LottoNumber.from(1)
        lotto1 shouldBe lotto2
        lotto1 shouldBeSameInstanceAs lotto2
    }
}
