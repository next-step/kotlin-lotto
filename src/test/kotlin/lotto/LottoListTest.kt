package lotto

import lotto.domain.Grade
import lotto.domain.LottoList
import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers
import lotto.domain.Money
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class LottoListTest {

    @Test
    fun `전체 로또의 결과 정보를 리턴한다`() {
        val firstGrade = LottoNumbers(1, 2, 3, 4, 5, 6)
        val secondGrade1 = LottoNumbers(1, 2, 3, 4, 5, 45)
        val secondGrade2 = LottoNumbers(1, 2, 3, 4, 6, 45)
        val thirdGrade = LottoNumbers(1, 2, 3, 4, 44, 45)
        val fourthGrade = LottoNumbers(1, 2, 3, 43, 44, 45)
        val noneGrade = LottoNumbers(1, 2, 42, 43, 44, 45)

        val lottoList =
            LottoList(listOf(firstGrade, secondGrade1, secondGrade2, thirdGrade, fourthGrade, noneGrade), Money(0))

        val winningNumbers = WinningNumbers(1, 2, 3, 4, 5, 6)

        val result = lottoList.match(winningNumbers)

        Assertions.assertThat(result.getMatchedCount(Grade.First)).isEqualTo(1)
        Assertions.assertThat(result.getMatchedCount(Grade.Second)).isEqualTo(2)
        Assertions.assertThat(result.getMatchedCount(Grade.Third)).isEqualTo(1)
        Assertions.assertThat(result.getMatchedCount(Grade.Fourth)).isEqualTo(1)
    }

    private fun LottoNumbers(vararg numbers: Int) = LottoNumbers(numbers.map(::LottoNumber))
    private fun WinningNumbers(vararg numbers: Int) = LottoNumbers(numbers.map(::LottoNumber))
}
