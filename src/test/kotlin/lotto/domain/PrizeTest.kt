package lotto.domain

import io.kotest.matchers.shouldBe
import lotto.domain.model.Lotto
import lotto.domain.model.LottoResult
import lotto.domain.model.SelectedBalls
import lotto.domain.model.WinningBalls
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class PrizeTest {
    @MethodSource("provideLottoResultExceptBonus")
    @ParameterizedTest
    fun `당첨 번호로 일치하는 결과를 구한다`(expectedResult: LottoResult) {
        val lotto = Lotto()
        val winningNumbers = mutableListOf<Int>().apply {
            val matchCount = expectedResult.prize.matches

            // 로또의 숫자를 기준으로 일정 갯수의 당첨 번호를 생성
            val tempWinningNumbers = lotto.numbers.subList(0, matchCount)
            addAll(tempWinningNumbers)

            // 절대 일치하지 않도록 범위 밖의 값을 남은 숫자만큼 넣어줌
            repeat(lotto.numbers.size - tempWinningNumbers.size) { add(0) }
        }

        // bonus 번호가 일치하지 없도록 범위 밖의 숫자를 넣어줌
        val bonus = -1

        val selectedBalls = SelectedBalls(WinningBalls(winningNumbers), bonus)

        Lotto.Prize.from(selectedBalls, lotto) shouldBe expectedResult.prize
    }

    @Test
    fun `2등 결과를 구한다`() {
        val expectedResult = LottoResult(1, Lotto.Prize.FIVE_MATCH_PLUS_BONUS)

        val lotto = Lotto()

        // 마지막 숫자를 보너스 숫자로 설정
        val bonus = lotto.numbers[lotto.numbers.size - 1]

        val winningNumbers = mutableListOf<Int>().apply {
            val matchCount = expectedResult.prize.matches

            // 로또의 숫자를 기준으로 일정 갯수의 당첨 번호를 생성
            val tempWinningNumbers = lotto.numbers.subList(0, matchCount)
            addAll(tempWinningNumbers)

            // 절대 일치하지 않도록 범위 밖의 값을 남은 숫자만큼 넣어줌
            repeat(lotto.numbers.size - tempWinningNumbers.size) { add(0) }
        }

        val selectedBalls = SelectedBalls(WinningBalls(winningNumbers), bonus)

        Lotto.Prize.from(selectedBalls, lotto) shouldBe expectedResult.prize
    }

    companion object {
        @JvmStatic
        fun provideLottoResultExceptBonus(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(LottoResult(1, Lotto.Prize.SIX_MATCH)),
                Arguments.of(LottoResult(1, Lotto.Prize.FIVE_MATCH)),
                Arguments.of(LottoResult(1, Lotto.Prize.FOUR_MATCH)),
                Arguments.of(LottoResult(1, Lotto.Prize.THREE_MATCH)),
                Arguments.of(LottoResult(1, Lotto.Prize.NOTHING)),
            )
        }
    }
}
