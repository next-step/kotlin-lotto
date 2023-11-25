package lotto.domain

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class WinningLottoTest {
    @ParameterizedTest
    @MethodSource("getLottoBonusNumberPair")
    fun `보너스 번호는 당첨 번호와 중복될 수 없다`(lottoBonusNumberPair: Pair<Lotto, LottoNumber>) {
        // given
        val (lotto, bonusNumber) = lottoBonusNumberPair

        // when & then
        assertThrows<IllegalArgumentException> { WinningLotto(lotto, bonusNumber) }
    }

    companion object {
        @JvmStatic
        fun getLottoBonusNumberPair() = listOf(
            Pair(Lotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber.of(it) }), LottoNumber.of(1)),
            Pair(Lotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber.of(it) }), LottoNumber.of(2)),
            Pair(Lotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber.of(it) }), LottoNumber.of(3))
        )
    }
}
