package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.domain.number.LottoNumber
import lotto.domain.number.LottoNumberResult

class WinningLottoTest : StringSpec({
    "로또 당첨 번호와 보너스 볼이 중복되면 실패가 반환된다." {
        listOf(2, 3, 6, 7, 8, 9).forEach { number ->
            // given
            val lottoResult = Lotto.createFromNumbers(listOf(2, 3, 6, 7, 8, 9))
            val winningLotto = lottoResult as LottoResult.Success

            val lottoNumberResult = LottoNumber.createResult(number)
            val bonusBall = lottoNumberResult as LottoNumberResult.Success

            // when
            val result = WinningLotto.createResult(winningLotto.data, bonusBall.data)

            // then
            result shouldBe WinningLottoResult.Failure("보너스 볼은 당첨 번호와 중복될 수 없습니다.")
        }
    }
})
