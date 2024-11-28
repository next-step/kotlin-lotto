package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.shouldBe

class LottoMachineTest : StringSpec({
    "티켓 수 만큼 로또를 생성한다" {
        listOf(1, 2, 3, 4, 5).forAll { count ->
            LottoMachine.autoPurchase(List(count) { AutoTicket }).size shouldBe count
        }
    }

    "로또 번호를 통해 수동생성한다" {
        val ticket1 = ManualTicket(setOf(1, 2, 3, 4, 5, 6))
        val ticket2 = ManualTicket(setOf(45, 44, 43, 42, 41, 40))
        val lottos = LottoMachine.manualPurchase(listOf(ticket1, ticket2))

        lottos.size shouldBe 2
        lottos[0].lottoNumbers.numbers shouldContainAll
            setOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6),
            )
        lottos[1].lottoNumbers.numbers shouldContainAll
            setOf(
                LottoNumber(40),
                LottoNumber(41),
                LottoNumber(42),
                LottoNumber(43),
                LottoNumber(44),
                LottoNumber(45),
            )
    }
})
