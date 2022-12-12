package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class LottoNumbersMatcherTest : DescribeSpec({
    describe("로또 번호 매칭 테스트") {
        val ticketingLottoList = Lotto((1..6).map(LottoNumber::of).toSet())
        val winningLotto = Lotto((4..9).map(LottoNumber::of).toSet())

        it("로또 번호와 당첨 번호 사이의 일치하는 숫자 갯수를 계산할 수 있다.") {
            val matchedCount = LottoNumbersMatcher.calculateMatchCount(ticketingLottoList, winningLotto)

            matchedCount shouldBe 3
        }
    }
})
