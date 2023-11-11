package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.row

class WinningLottoSpec : FunSpec({
    test("당첨 티켓과 보너스 볼로 당첨 로또가 생성된다") {
        WinningLotto(LottoTicket(listOf(1, 2, 3, 4, 5, 6)), 45)
    }
    test("당첨 번호에 보너스 볼이 포함되어 있으면 에러가 발생한다") {
        shouldThrow<IllegalArgumentException> {
            WinningLotto(LottoTicket(listOf(1, 2, 3, 4, 5, 6)), 6)
        }
    }
    test("보너스볼이 1부터 45사이의 숫자가 아니라면 에러가 발생한다") {
        forAll(
            row(0),
            row(46),
        ) { bonusNumber ->
            shouldThrow<IllegalArgumentException> {
                WinningLotto(LottoTicket(listOf(1, 2, 3, 4, 5, 6)), bonusNumber)
            }
        }
    }
})
