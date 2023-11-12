package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import java.lang.IllegalArgumentException

class LottoMockSpec : FunSpec({
    test("주어진 당첨 조건에 해당하는 로또 티켓 생성") {
        val winningLotto = WinningLotto(LottoNumber(listOf(1, 2, 3, 4, 5, 6)), 7)
        forAll(
            row(0, false),
            row(1, false),
            row(2, false),
            row(3, false),
            row(4, false),
            row(5, false),
            row(5, true),
            row(6, false),
        ) { matchedCount, hasMatchedBonus ->

            val result = LottoMock.createTicket(winningLotto, matchedCount, hasMatchedBonus)

            result.value.count { winningLotto.winningNumber.value.contains(it) } shouldBe matchedCount
            result.value.contains(winningLotto.bonusNumber) shouldBe hasMatchedBonus
        }
    }

    test("맞은 수가 0이상 6이하가 아니면 생성 실패") {
        val winningLotto = WinningLotto(LottoNumber(listOf(1, 2, 3, 4, 5, 6)), 7)

        shouldThrow<IllegalArgumentException> {
            LottoMock.createTicket(winningLotto, 7, false)
        }
    }

    test("보너스 볼을 맞혔는데 당첨 번호 맞은 수가 6이면 생성 실패") {
        val winningLotto = WinningLotto(LottoNumber(listOf(1, 2, 3, 4, 5, 6)), 7)
        shouldThrow<IllegalArgumentException> {
            LottoMock.createTicket(winningLotto, 6, true)
        }
    }
})
