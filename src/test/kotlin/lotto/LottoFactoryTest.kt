package lotto

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LottoFactoryTest : FunSpec({
    test("구매한 로또 개수만큼 로또 티켓을 만들어줄 수 있다.") {
        // given
        val lottoTickets: LottoTickets = LottoFactory.auto(count = 5)
        println(lottoTickets)

        // when
        val result = lottoTickets.size()

        // then
        result shouldBe 5
    }
})
