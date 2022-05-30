package lotto.domain.prize

import lotto.domain.Lotto
import lotto.domain.WinningLotto
import lotto.domain.numbers.CustomNumbersGenerator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoPrizeCalculatorTest {
    @Test
    fun `3, 4, 5, 6개 일치하는 로또 갯수를 계산할 수 있다`() {
        val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6))

        val noMatchingLotto = Lotto(numbersGenerator = CustomNumbersGenerator(listOf(45, 44, 43, 42, 41, 40)))
        val oneMatchingLotto = Lotto(numbersGenerator = CustomNumbersGenerator(listOf(45, 44, 43, 42, 41, 1)))
        val twoMatchingLotto = Lotto(numbersGenerator = CustomNumbersGenerator(listOf(45, 44, 43, 42, 2, 1)))
        val threeMatchingLotto = Lotto(numbersGenerator = CustomNumbersGenerator(listOf(1, 2, 3, 45, 44, 43)))
        val fourMatchingLotto = Lotto(numbersGenerator = CustomNumbersGenerator(listOf(1, 2, 3, 4, 45, 44)))
        val fiveMatchingLotto1 = Lotto(numbersGenerator = CustomNumbersGenerator(listOf(1, 2, 3, 4, 5, 45)))
        val fiveMatchingLotto2 = Lotto(numbersGenerator = CustomNumbersGenerator(listOf(1, 2, 3, 4, 5, 44)))
        val sixMatchingLotto2 = Lotto(numbersGenerator = CustomNumbersGenerator(listOf(6, 5, 4, 3, 2, 1)))

        val prizeCalculator = LottoPrizeCalculator(
            winningLotto,
            listOf(
                noMatchingLotto,
                oneMatchingLotto,
                twoMatchingLotto,
                threeMatchingLotto,
                fourMatchingLotto,
                fiveMatchingLotto1,
                fiveMatchingLotto2,
                sixMatchingLotto2
            )
        )

        val expectedPrizes = listOf(
            LottoPrize.MISS,
            LottoPrize.MISS,
            LottoPrize.MISS,
            LottoPrize.FOURTH,
            LottoPrize.THIRD,
            LottoPrize.SECOND,
            LottoPrize.SECOND,
            LottoPrize.FIRST
        )

        assertThat(prizeCalculator.prizes).isEqualTo(expectedPrizes)
        assertThat(prizeCalculator.numberOf(LottoPrize.FIRST)).isEqualTo(1)
        assertThat(prizeCalculator.numberOf(LottoPrize.SECOND)).isEqualTo(2)
    }

    @Test
    fun `당첨 번호와 일치하는 로또의 총 수익을 계산할 수 있다`() {
        val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6))

        val noMatchingLotto = Lotto(numbersGenerator = CustomNumbersGenerator(listOf(45, 44, 43, 42, 41, 40)))
        val oneMatchingLotto = Lotto(numbersGenerator = CustomNumbersGenerator(listOf(45, 44, 43, 42, 41, 1)))
        val twoMatchingLotto = Lotto(numbersGenerator = CustomNumbersGenerator(listOf(45, 44, 43, 42, 2, 1)))
        val threeMatchingLotto = Lotto(numbersGenerator = CustomNumbersGenerator(listOf(1, 2, 3, 45, 44, 43)))
        val fourMatchingLotto = Lotto(numbersGenerator = CustomNumbersGenerator(listOf(1, 2, 3, 4, 45, 44)))
        val fiveMatchingLotto1 = Lotto(numbersGenerator = CustomNumbersGenerator(listOf(1, 2, 3, 4, 5, 45)))
        val fiveMatchingLotto2 = Lotto(numbersGenerator = CustomNumbersGenerator(listOf(1, 2, 3, 4, 5, 44)))
        val sixMatchingLotto2 = Lotto(numbersGenerator = CustomNumbersGenerator(listOf(6, 5, 4, 3, 2, 1)))

        val prizeCalculator = LottoPrizeCalculator(
            winningLotto,
            listOf(
                noMatchingLotto,
                oneMatchingLotto,
                twoMatchingLotto,
                threeMatchingLotto,
                fourMatchingLotto,
                fiveMatchingLotto1,
                fiveMatchingLotto2,
                sixMatchingLotto2
            )
        )

        val expectedPrizes = listOf(
            LottoPrize.MISS,
            LottoPrize.MISS,
            LottoPrize.MISS,
            LottoPrize.FOURTH,
            LottoPrize.THIRD,
            LottoPrize.SECOND,
            LottoPrize.SECOND,
            LottoPrize.FIRST
        )

        val expectedTotalPrize = expectedPrizes.sumOf { it.prizeAmount }

        assertThat(prizeCalculator.totalPrizeAmount).isEqualTo(expectedTotalPrize)
    }
}
