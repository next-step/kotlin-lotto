package lotto.fixture

import lotto.domain.Order

class OrderFixture {

    companion object {
        fun `주어진 개수 만큼 주문 내역 생성`(total: Int): Order {
            return Order.of(total, 0, listOf())
        }
    }
}
