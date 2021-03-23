package lotto.domain

import lotto.domain.generator.AutoLottoGenerator
import lotto.domain.generator.ManualLottoGenerator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoMachineTest {
    @Test
    fun `로또 자동 구매 테스트`() {
        val lotto = LottoMachine(AutoLottoGenerator()).buy()
        assertThat(lotto.numbers.size).isEqualTo(6)
    }

    @Test
    fun `로또 수동 구매 테스트`() {
        val lotto = LottoMachine(ManualLottoGenerator("1,2,3,4,5,6")).buy()
        assertThat(lotto.numbers.size).isEqualTo(6)
        assertThat(lotto.numbers[0]).isEqualTo(LottoNumber.from(1))
        assertThat(lotto.numbers[1]).isEqualTo(LottoNumber.from(2))
        assertThat(lotto.numbers[2]).isEqualTo(LottoNumber.from(3))
        assertThat(lotto.numbers[3]).isEqualTo(LottoNumber.from(4))
        assertThat(lotto.numbers[4]).isEqualTo(LottoNumber.from(5))
        assertThat(lotto.numbers[5]).isEqualTo(LottoNumber.from(6))
    }
}
