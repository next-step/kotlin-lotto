package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AutoLottoMakerTest {

    @Test
    fun `객체 생성`() {
        val make = AutoLottoMaker().make()
        assertThat(make.numbers.size).isEqualTo(6)
    }
}
