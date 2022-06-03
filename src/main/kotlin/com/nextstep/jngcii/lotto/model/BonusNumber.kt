package com.nextstep.jngcii.lotto.model

class BonusNumber(
    number: Int,
    lastWeekLotto: Lotto
) : LottoNumber(number) {
    init {
        require(number !in lastWeekLotto.numbers) {
            "보너스넘버는 지난주 로또넘버 6개에 포함될 수 없습니다."
        }
    }
}
