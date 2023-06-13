package lotto

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.DisplayName
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

private const val i = 1000

@DisplayName("로또 상점")
class LottoStoreTest : StringSpec({

    "로또 저장소와 로또 금액으로 생성" {
        listOf(1, 1000, Int.MAX_VALUE).forAll {
            shouldNotThrowAny {
                LottoStore(OneToSixLottoTicketStorage, it)
            }
        }
    }

    "로또 금액은 반드시 양수" {
        listOf(Int.MIN_VALUE, -1, 0).forAll {
            shouldThrowExactly<IllegalArgumentException> {
                LottoStore(OneToSixLottoTicketStorage, it)
            }
        }
    }

    "로또 금액이 1000원만큼 구매할 수 있는 개수의 티켓 목록 반환" {
        listOf(
            0 to 0,
            500 to 0,
            1000 to 1,
            1500 to 1,
            4100 to 4
        ).forAll {
            // given
            val oneThousandPrice = 1000
            val maxPriceStore = LottoStore(OneToSixLottoTicketStorage, oneThousandPrice)
            // when
            val purchasedLottoTickets: PurchasedLottoTickets = maxPriceStore purchasedLottoTickets it.first
            // then
            purchasedLottoTickets shouldBe
                    PurchasedLottoTickets(
                        (0 until it.second).map { ONE_TO_SIX_LOTTO_TICKET }, oneThousandPrice
                    )
        }
    }
})
