package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class LottosTest {
    @Test
    fun `로또 리스트 - 리스트 반환 테스트`() {
        // given
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber.from(it) })
        val lottos = Lottos(listOf(lotto))

        // when
        val actual = lottos.getList()

        // then
        assertThat(actual).contains(listOf(1, 2, 3, 4, 5, 6))
    }

    @Test
    fun `로또 리스트 - 중복에 대한 예외처리 테스트`() {
        // given
        val lotto1 = Lotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber.from(it) })
        val lotto2 = Lotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber.from(it) })

        // when, then
        assertThatThrownBy { Lottos(listOf(lotto1, lotto2)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("로또 번호는 중복될 수 없습니다.")
    }

    @Test
    fun `로또 리스트 - 병합 테스트`() {
        // given
        val lotto1 = Lotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber.from(it) })
        val lotto2 = Lotto(listOf(7, 8, 9, 10, 11, 12).map { LottoNumber.from(it) })
        val lottos1 = Lottos(listOf(lotto1))
        val lottos2 = Lottos(listOf(lotto2))

        // when
        val actual = lottos1.plus(lottos2)

        // then
        assertThat(actual.value).contains(lotto1, lotto2)
    }

    @Test
    fun `로또 리스트 - 중복 병합에 대한 예외처리 테스트`() {
        // given
        val lotto1 = Lotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber.from(it) })
        val lotto2 = Lotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber.from(it) })
        val lottos1 = Lottos(listOf(lotto1))
        val lottos2 = Lottos(listOf(lotto2))

        // when, then
        assertThatThrownBy { lottos1.plus(lottos2) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("로또 번호는 중복될 수 없습니다.")
    }
}
