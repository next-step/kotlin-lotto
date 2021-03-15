package lotto.vo

import lotto.domain.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class LottoTest {
    @Test
    @DisplayName("로또는 로또번호를 6개 가질 수 있다")
    fun lottoSizeTest() {
        val manualLottoNumber = setOf(1, 2, 3, 4, 5, 6)
        val lotto = Lotto.of(manualLottoNumber).lottoNumbers
        assertThat(lotto.size).isEqualTo(6)
    }

    @Test
    @DisplayName("로또는 로또번호를 7개 이상 가질 수 없다")
    fun lottoOverSizeLimitTest() {
        val manualLottoNumber = setOf(1, 2, 3, 4, 5, 6, 7)
        assertThrows<IllegalArgumentException> { Lotto.of(manualLottoNumber) }
    }

    @Test
    @DisplayName("로또는 로또번호를 5개 이하 가질 수 없다")
    fun lottoUnderSizeLimitTest() {
        val manualLottoNumber = setOf(1, 2, 3, 4, 5)
        assertThrows<IllegalArgumentException> { Lotto.of(manualLottoNumber) }
    }

    @Test
    @DisplayName("로또는 같은 로또번호를 중복해서 가질 수 없다")
    fun lottoDuplicateExceptionTest() {
        val manualLottoNumber = listOf(1, 2, 3, 4, 5, 5)
        assertThrows<IllegalArgumentException> { Lotto.of(manualLottoNumber.toSet()) }
    }
}
