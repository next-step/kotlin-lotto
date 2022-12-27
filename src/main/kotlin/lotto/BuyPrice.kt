package lotto

import lotto.LottoOffice.ONE_LOTTO_PRICE


class BuyPrice(val price: Int) {
    init {
        require(price >= ONE_LOTTO_PRICE) {
            "투입하신 금액은 $price 입니다. \n 구매하기 위한 최소 금액은 $ONE_LOTTO_PRICE 입니다."
        }
    }
}
