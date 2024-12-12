package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldNotBeSameInstanceAs

class LottoTicketTest : DescribeSpec({
    describe("방어적 복사 테스트") {
        it("should not same instance") {
            val lottos =
                listOf(
                    Lotto(1, 2, 3, 4, 5, 6),
                    Lotto(1, 2, 3, 4, 5, 6),
                    Lotto(1, 2, 3, 4, 5, 6),
                )

            val lottoTicket = LottoTicket(lottos)

            lottos shouldNotBeSameInstanceAs lottoTicket.tickets
        }
    }

    describe("수동 로또와 자동 로또를 하나의 리스트로 합친다") {
        it("파라미터로 받은 로또 리스트를 하나의 리스트로 합친뒤 반환한다.") {
            val manualLottos =
                listOf(
                    Lotto(1, 2, 3, 4, 5, 6),
                    Lotto(1, 2, 3, 4, 5, 6),
                    Lotto(1, 2, 3, 4, 5, 6),
                )

            val autoLottos =
                listOf(
                    Lotto(1, 2, 3, 4, 5, 6),
                    Lotto(1, 2, 3, 4, 5, 6),
                )

            val sut = LottoTicket(autoLottos)
            val actual = sut.flatLottos(LottoTicket(manualLottos))
            actual.tickets.size shouldBe 5
        }
    }
})
