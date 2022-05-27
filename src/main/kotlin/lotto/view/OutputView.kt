package lotto.view

import lotto.domain.LottoPurchase.Companion.LOTTO_PRICE

class OutputView {
    fun cannotPurchaseLotto() {
        print("로또 한개의 가격은 $LOTTO_PRICE 입니다. 그 이상을 입력해 주세요.")
    }
}
