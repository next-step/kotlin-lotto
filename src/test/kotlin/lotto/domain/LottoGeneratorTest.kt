package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoGeneratorTest {

    @Test
    fun `로또 생성기의 Range 는 1부터 45의 범위를 가진다`() {
        assertThat(LottoGenerator.DEFAULT_RANGE.first).isEqualTo(1)
        assertThat(LottoGenerator.DEFAULT_RANGE.last).isEqualTo(45)
    }

    @Test
    fun `로또 클래스를 반환하는 generato 메소드 생성`() {
        var lotto = LottoGenerator().generate()

        assertThat(lotto).isExactlyInstanceOf(Lotto::class.java)
    }
}
