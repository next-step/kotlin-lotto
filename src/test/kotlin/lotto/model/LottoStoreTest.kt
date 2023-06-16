package lotto.model

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.DisplayName
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

@DisplayName("로또 상점")
class LottoStoreTest : StringSpec({

    "로또 주 저장소, 부 저장소, 로또 금액으로 생성" {
        listOf(1L, 1000L, Long.MAX_VALUE).forAll {
            shouldNotThrowAny {
                LottoStore(OneToSixLottoTicketStorage, OneToSixLottoTicketStorage, it)
            }
        }
    }

    "로또 금액은 반드시 양수" {
        listOf(Long.MIN_VALUE, -1L, 0L).forAll {
            shouldThrowExactly<IllegalArgumentException> {
                LottoStore(OneToSixLottoTicketStorage, OneToSixLottoTicketStorage, it)
            }
        }
    }

    "로또 금액이 1000원만큼 구매할 수 있는 개수의 티켓 목록 반환" {
        listOf(
            0L to 0,
            500L to 0,
            1_000L to 1,
            1_500L to 1,
            4_100L to 4
        ).forAll {
            // given
            val oneThousandPrice = 1_000L
            val maxPriceStore = LottoStore(OneToSixLottoTicketStorage, OneToSixLottoTicketStorage, oneThousandPrice)
            // when
            val purchasedLottoTickets: PurchasedLottoTickets = maxPriceStore.purchaseLottoTicketsBy(0, it.first)
            // then
            purchasedLottoTickets shouldBe
                PurchasedLottoTickets(
                    (0 until it.second).map { ONE_TO_SIX_AUTO_LOTTO_TICKET }, oneThousandPrice
                )
        }
    }

    "구매할 수 있는 개수보다 메인 스토리지에서 구매할 개수가 크면 예외" {
        // given
        val oneThousandPrice = 1_000L
        val store = LottoStore(OneToSixLottoTicketStorage, OneToSixLottoTicketStorage, oneThousandPrice)
        // when & then
        shouldThrowExactly<IllegalArgumentException> {
            store.purchaseLottoTicketsBy(10, oneThousandPrice)
        }
    }

    "메인 저장소가 비어있고 메인 저장소에서 구매할 개수가 크면 예외" {
        // given
        val oneThousandPrice = 1_000L
        val maxPriceStore = LottoStore(EmptyLottoTicketStorage, OneToSixLottoTicketStorage, oneThousandPrice)
        // when & then
        shouldThrowExactly<IllegalStateException> {
            maxPriceStore.purchaseLottoTicketsBy(10, 10_000L)
        }
    }
})

private object OneToSixLottoTicketStorage : LottoTicketStorage {

    override fun hasCountLessThan(count: Int): Boolean {
        return false
    }

    override fun lottoTicketsBy(count: Int): Collection<LottoTicket> {
        return (0 until count).map { ONE_TO_SIX_AUTO_LOTTO_TICKET }
    }
}

private object EmptyLottoTicketStorage : LottoTicketStorage {

    override fun hasCountLessThan(count: Int): Boolean {
        return true
    }

    override fun lottoTicketsBy(count: Int): Collection<LottoTicket> {
        return listOf()
    }
}
