package lotto.domain

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.StringSpec
import lotto.domain.number.LottoNumber

class WinningLottoTest : StringSpec({
    "로또 당첨 번호와 보너스 볼이 중복되면 예외가 발생한다." {
        listOf(2, 3, 6, 7, 8, 9).forEach { number ->
            // given
            val winningLotto = Lotto.createFromNumbers(listOf(2, 3, 6, 7, 8, 9))
            val bonusBall = LottoNumber.from(number)

            // exepcted
            shouldThrowWithMessage<IllegalArgumentException>("보너스 볼은 당첨 번호와 중복될 수 없습니다.") {
                WinningLotto(winningLotto, bonusBall)
            }
        }
    }
})
