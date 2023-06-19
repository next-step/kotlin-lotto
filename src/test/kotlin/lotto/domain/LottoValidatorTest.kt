package lotto.domain

import io.kotest.matchers.shouldBe
import lotto.domain.model.Lotto
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoValidatorTest {
    @ValueSource(ints = [0, 1, 2, 3, 4, 5, 6])
    @ParameterizedTest
    fun `당첨 번호로 일치하는 숫자의 개수를 구한다`(winningCount: Int) {
        val lotto = Lotto()
        val winningNumbers = mutableListOf<Int>().apply {
            // 로또의 숫자를 기준으로 일정 갯수의 당첨 번호를 생성
            val tempWinningNumbers = lotto.numbers.subList(0, winningCount)
            addAll(tempWinningNumbers)

            // 절대 일치하지 않도록 범위 밖의 값을 남은 숫자만큼 넣어줌
            repeat(lotto.numbers.size - tempWinningNumbers.size) { add(0) }
        }

        // 6개의 당첨 숫자가 구성되었는지 체크
        winningNumbers.size shouldBe lotto.numbers.size

        LottoValidator(winningNumbers).winningCount(lotto) shouldBe winningCount
    }
}
