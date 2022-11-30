package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class LottoNumbersMatcherTest : DescribeSpec ({
    describe("로또 번호 매칭 테스트") {
        val ticketingLottoList = listOf(Lotto(listOf(1, 2, 3, 4, 5)))
        val winningLotto = Lotto(listOf(1, 2, 3, 6, 7))


        it("로또 번호와 당첨 번호 사이의 일치하는 숫자 갯수를 계산할 수 있다.") {
            val matchedCount = LottoNumbersMatcher.calculateMatchCount(ticketingLottoList, winningLotto)

            matchedCount shouldBe 3
        }
    }
})