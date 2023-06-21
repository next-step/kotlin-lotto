package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class LottoTest {

    @Test
    internal fun `로또는 6개의 번호를 가진다`() {
        val sut = Lotto(setOf(1, 2, 3, 4, 5, 6))
        sut.numbers shouldContainExactly setOf(1, 2, 3, 4, 5, 6)
    }

    @Test
    internal fun `로또가 6개의 번호를 가지지 않으면 예외가 발생한다`() {
        shouldThrow<IllegalArgumentException> { Lotto(setOf(1, 2, 3, 4, 5)) }
    }

    @Test
    internal fun `로또 번호가 1부터 45사이의 값이 아닌 경우 예외가 발생한다`() {
        shouldThrow<IllegalArgumentException> { Lotto(setOf(-1, 0, 1, 20, 45, 46)) }
    }

    @Test
    internal fun `로또 번호가 서로 중복되는 경우 예외가 발생한다`() {
        shouldThrow<IllegalArgumentException> { Lotto(setOf(3, 3, 17, 20, 40, 45)) }
    }

    @ParameterizedTest
    @CsvSource(
        "1, 2, 3, 4, 5, 6, 6, false, FIRST",
        "1, 2, 3, 4, 5, 7, 5, true, SECOND",
        "1, 2, 3, 4, 5, 45, 5, false, THIRD",
        "1, 2, 3, 4, 44, 45, 4, false, FOURTH",
        "1, 2, 3, 43, 44, 45, 3, false, FIFTH",
        "1, 2, 42, 43, 44, 45, 2, false, MISS",
        "1, 41, 42, 43, 44, 45, 1, false, MISS",
        "40, 41, 42, 43, 44, 45, 0, false, MISS",
    )
    internal fun `로또는 당첨된 로또와 비교했을때 번호가 몇개 일치하는지 알 수 있어야한다`(
        first: Int,
        second: Int,
        third: Int,
        forth: Int,
        fifth: Int,
        sixth: Int,
        expectedMatchCount: Int,
        expectedbonusMatched: Boolean,
        expectedRank: String,
    ) {
        // given : 당첨 번호와 로또 하나 준비
        val winningLotto = WinningLotto(
            winningNumbers = setOf(1, 2, 3, 4, 5, 6),
            bonusNumber = 7
        )
        val sut = Lotto(setOf(first, second, third, forth, fifth, sixth))

        // when : 당첨 번호와 로또 비교 후 번호 비교 결과를 반환 받음
        val lottoMatchResult: LottoMatchResult = sut.match(winningLotto)

        // then : 번호 비교 결과를 통해 로또가 당첨 번호및 보너스 번호와 몇개 일치하는지 알 수 있음
        lottoMatchResult.matchCount shouldBe expectedMatchCount
        lottoMatchResult.bonusMatched shouldBe expectedbonusMatched
        // and : 번호 비교 결과를 통해 로또의 등수를 알 수 있음
        lottoMatchResult.rank shouldBe LottoRank.valueOf(expectedRank)
    }
}
