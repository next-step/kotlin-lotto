package lotto

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import lotto.domain.Lotto

class LottoTest : FunSpec({
    test("로또를 처음 생성하면 pickNumbers의 개수는 6이고, matchCount는 0이다.") {
        // given
        val givenPickNumbers = listOf(1, 2, 3, 4, 5, 6)

        // when
        val result = Lotto.of(givenPickNumbers)

        // then
        result.pickNumbers.distinct().size shouldBe 6
        result.matchCount shouldBe 0
    }

    test("updateMatchCount를 호출하면 matchCount가 변경된다.") {
        // given
        val givenLotto = LottoStub.get()
        val givenMatchCount = 3

        // when
        val result = givenLotto.updateMatchCount(givenMatchCount)

        // then
        result.matchCount shouldBe givenMatchCount
    }
})
