package domain.lotto

import domain.winning.WinningCategory
import domain.winning.WinningNumbers
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottosTest {
    @ParameterizedTest(name = "총 로또 중 6개 모두 일치하는 로또의 개수는 {0}개여야 한다")
    @ValueSource(ints = [1, 2])
    fun `총 로또 중 6개 모두 일치하는 로또의 개수를 구한다`(expectedCount: Int) {
        // given
        val numbers = lottoNumberOf(1, 2, 3, 4, 5, 6)
        val winningNumbers = WinningNumbers(numbers, bonus = LottoNumber.parse(7))
        val lottos = Lottos((1..expectedCount).map { Lotto(numbers) })
        val expected = mapOf(WinningCategory.SIX_CORRECT to expectedCount)

        // when
        val actual = lottos.matches(winningNumbers)

        // then
        Assertions.assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest(name = "총 로또 중 5개 일치하는 로또의 개수는 {0}개여야 한다")
    @ValueSource(ints = [1, 2])
    fun `총 로또 중 5개 일치하는 로또의 개수를 구한다`(expectedCount: Int) {
        // given
        val winningNumbers = WinningNumbers(
            numbers = lottoNumberOf(1, 2, 3, 4, 5, 6),
            bonus = LottoNumber.parse(7)
        )
        val lottoNumbers = lottoNumberOf(1, 2, 3, 4, 5, 45)
        val lottos = Lottos((1..expectedCount).map { Lotto(lottoNumbers) })
        val expected = mapOf(WinningCategory.FIVE_CORRECT to expectedCount)

        // when
        val actual = lottos.matches(winningNumbers)

        // then
        Assertions.assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `로또들을 더하면 더한 순서대로 합쳐진다`() {
        // given
        val lotto1st = Lotto(lottoNumberOf(1, 2, 3, 4, 5, 6))
        val lotto2nd = Lotto(lottoNumberOf(2, 3, 4, 5, 6, 7))
        val lotto3rd = Lotto(lottoNumberOf(3, 4, 5, 6, 7, 8))
        val lotto4th = Lotto(lottoNumberOf(4, 5, 6, 7, 8, 9))
        val expected = listOf(lotto1st, lotto2nd, lotto3rd, lotto4th)

        // when
        val concatenatedLottos = Lottos(listOf(lotto1st, lotto2nd)) + Lottos(listOf(lotto3rd, lotto4th))
        val actual = concatenatedLottos.toList()

        // then
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest
    @ValueSource(ints = [3, 10])
    fun `보유한 로또 중 수동선택 로또의 개수를 반환할 수 있다`(expectedCount: Int) {
        // given
        val manualLotto = Lotto(lottoNumberOf(1, 2, 3, 4, 5, 6), PickType.MANUAL)
        val manuals = List(expectedCount) { manualLotto }
        val lottos = Lottos(manuals)

        // when
        val actual = lottos.countBy(PickType.MANUAL)

        // then
        assertThat(actual).isEqualTo(expectedCount)
    }

    @ParameterizedTest
    @ValueSource(ints = [3, 10])
    fun `보유한 로또 중 자동선택 로또의 개수를 반환할 수 있다`(expectedCount: Int) {
        // given
        val autoLotto = Lotto(lottoNumberOf(1, 2, 3, 4, 5, 6), PickType.AUTO)
        val autos = List(expectedCount) { autoLotto }
        val lottos = Lottos(autos)

        // when
        val actual = lottos.countBy(PickType.AUTO)

        // then
        assertThat(actual).isEqualTo(expectedCount)
    }

    @Test
    fun `수동개수와 자동개수의 합은 총합과 같다`() {
        // given
        val manualCount = 5
        val manualLotto = Lotto(lottoNumberOf(1, 2, 3, 4, 5, 6), PickType.MANUAL)
        val manuals = List(manualCount) { manualLotto }

        val autoCount = 3
        val autoLotto = Lotto(lottoNumberOf(1, 2, 3, 4, 5, 6), PickType.AUTO)
        val autos = List(autoCount) { autoLotto }

        val lottos = Lottos(manuals + autos)
        val expectedCount = lottos.size

        // when
        val actual = lottos.countBy(PickType.MANUAL) + lottos.countBy(PickType.AUTO)

        // then
        assertThat(actual).isEqualTo(expectedCount)
    }
}
