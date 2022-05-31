package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AutoLottoMakerTest {

    @Test
    fun `1과 45 사이의 숫자를 중복 없이 6개의 리스트를 갖는 로또 객체 생성`() {
        val make = AutoLottoMaker().make()
        assertThat(make.lotto.size).isEqualTo(6)
    }
}
