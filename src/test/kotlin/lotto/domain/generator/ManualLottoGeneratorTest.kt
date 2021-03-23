package lotto.domain.generator

import lotto.domain.LottoNumber
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class ManualLottoGeneratorTest {
    @Test
    fun `수동 로또 생성`() {
        val lotto = ManualLottoGenerator("1,2,3,4,5,6").generate()
        Assertions.assertThat(lotto.numbers.size).isEqualTo(6)
        Assertions.assertThat(lotto.numbers[0]).isEqualTo(LottoNumber.from(1))
        Assertions.assertThat(lotto.numbers[1]).isEqualTo(LottoNumber.from(2))
        Assertions.assertThat(lotto.numbers[2]).isEqualTo(LottoNumber.from(3))
        Assertions.assertThat(lotto.numbers[3]).isEqualTo(LottoNumber.from(4))
        Assertions.assertThat(lotto.numbers[4]).isEqualTo(LottoNumber.from(5))
        Assertions.assertThat(lotto.numbers[5]).isEqualTo(LottoNumber.from(6))
    }
}
