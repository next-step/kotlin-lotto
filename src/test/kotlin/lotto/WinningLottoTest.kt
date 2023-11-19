package lotto

import io.kotest.matchers.shouldBe
import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers
import lotto.domain.WinningLotto
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class WinningLottoTest {

    @ParameterizedTest
    @CsvSource(
        value = [
            "1,2,3,4,5,6 | 6 | 6",
            "2,3,4,5,6,7 | 5 | 5",
        ],
        delimiter = '|'
    )
    fun `전달받은 로또와 당첨 번호를 비교해 결과를 반환한다`(userLottoNumber: String, bonusNumber: Int, expected: Int) {
        val winningNumber = listOf(1, 2, 3, 4, 5, 6)
        val winningLotto = WinningLotto.create(winningNumber, bonusNumber)
        val userLottoNumbers = LottoNumbers(userLottoNumber.split(",").map { LottoNumber(it.toInt()) })
        val userLottos = listOf(Lotto(userLottoNumbers))
        val result = winningLotto.match(userLottos)

        result.getLottoRankCount(expected) shouldBe 1
    }
}
