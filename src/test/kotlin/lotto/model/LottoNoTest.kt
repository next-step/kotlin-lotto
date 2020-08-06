package lotto.model

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoNoTest {
    @DisplayName(value = "로또가 될 수 없는 숫자 확인")
    @Test
    fun lottoInvalidNumber() {
        assertThatThrownBy { (LottoNo.from("k".toInt())) }.isInstanceOf(RuntimeException::class.java)
        assertThatThrownBy { (LottoNo.from(0)) }.isInstanceOf(RuntimeException::class.java)
        assertThatThrownBy { (LottoNo.from(46)) }.isInstanceOf(RuntimeException::class.java)
    }
}
