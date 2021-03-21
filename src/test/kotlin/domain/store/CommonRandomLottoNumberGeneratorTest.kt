package domain.store

import domain.lotto.LottoNumber
import domain.lotto.LottoNumbers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

internal class CommonRandomLottoNumberGeneratorTest {
    @Test
    fun `무작위로또숫자생성기는 생성 시 아무 에러를 발생하지 않는다`() {
        assertDoesNotThrow { CommonRandomLottoNumberGenerator() }
    }

    @Test
    fun `무작위로또숫자생성기는 로또숫자열을 하나 생성한다`() {
        assertThat(CommonRandomLottoNumberGenerator().generate()).isInstanceOf(LottoNumbers::class.java)
    }

    @Test
    fun `무작위로또숫자생성기는 로또숫자의 최대 및 최소 숫자 사이의 숫자를, 로또숫자열의 최대 개수만큼 생성한다`() {
        val quickPick = CommonRandomLottoNumberGenerator().generate()
        assertThat(quickPick.numbers)
            .allMatch { LottoNumber.MIN <= it.value && it.value <= LottoNumber.MAX }
            .hasSize(LottoNumbers.SIZE)
    }
}
