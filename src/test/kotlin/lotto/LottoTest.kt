package lotto

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.LottoRank
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class LottoTest {

    @Test
    fun `로또를 생성할 수 있다`() {
        val lotto: Lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        assertThat(lotto).isNotNull
    }

    @Test
    fun `로또 번호를 가져올 수 있다`() {
        val lotto: Lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        val expectedLotto: List<LottoNumber> = listOf(LottoNumber(1), LottoNumber(2), LottoNumber(3), LottoNumber(4), LottoNumber(5), LottoNumber(6))

        assertThat(lotto.numberList).containsExactlyElementsOf(expectedLotto)
    }

    @Test
    fun `로또 번호가 겹치는 것을 반환`() {
        val firstLotto: Lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val secondLotto: Lotto = Lotto(listOf(1, 2, 3, 4, 5, 7))

        val matchCount: Int = firstLotto.getMatchCount(secondLotto)

        assertThat(matchCount).isEqualTo(5)
    }

    @Test
    fun `로또 번호는 정렬되어 있다`() {
        val lotto: Lotto = Lotto(listOf(6, 5, 4, 3, 2, 1))

        val expectedLotto: List<LottoNumber> = listOf(LottoNumber(1), LottoNumber(2), LottoNumber(3), LottoNumber(4), LottoNumber(5), LottoNumber(6))

        assertThat(lotto.numberList).containsExactlyElementsOf(expectedLotto)
    }

    @Test
    fun `로또 번호는 중복될 수 없다`() {
        Assertions.assertThatThrownBy { Lotto(listOf(1, 2, 3, 4, 5, 5)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("로또 번호는 중복될 수 없습니다.")
    }

    @ParameterizedTest
    @MethodSource("provideLottoNumberList")
    fun `로또 결과를 얻을 수 있다`(lotto: Lotto, winningLotto: Lotto, expected: LottoRank, bonusNumber: LottoNumber) {
        val lottoResult: LottoRank = lotto.getLottoRank(winningLotto, bonusNumber)

        assertThat(lottoResult).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        fun provideLottoNumberList(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(Lotto(listOf(1, 2, 3, 4, 5, 6)), Lotto(listOf(1, 2, 3, 4, 5, 6)), LottoRank.FIRST, LottoNumber(7)),
                Arguments.of(Lotto(listOf(1, 2, 3, 4, 5, 7)), Lotto(listOf(1, 2, 3, 4, 5, 6)), LottoRank.SECOND_WITH_BONUS, LottoNumber(7)),
                Arguments.of(Lotto(listOf(1, 2, 3, 4, 5, 7)), Lotto(listOf(1, 2, 3, 4, 5, 6)), LottoRank.SECOND, LottoNumber(45)),
                Arguments.of(Lotto(listOf(1, 2, 3, 4, 7, 8)), Lotto(listOf(1, 2, 3, 4, 5, 6)), LottoRank.THIRD, LottoNumber(45)),
                Arguments.of(Lotto(listOf(1, 2, 3, 7, 8, 9)), Lotto(listOf(1, 2, 3, 4, 5, 6)), LottoRank.FOURTH, LottoNumber(45)),
                Arguments.of(Lotto(listOf(1, 2, 7, 8, 9, 10)), Lotto(listOf(1, 2, 3, 4, 5, 6)), LottoRank.MISS, LottoNumber(45)),
                Arguments.of(Lotto(listOf(7, 8, 9, 10, 11, 12)), Lotto(listOf(1, 2, 3, 4, 5, 6)), LottoRank.MISS, LottoNumber(45)),
            )
        }
    }
}
