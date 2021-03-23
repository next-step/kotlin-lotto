package domain.lotto

import domain.money.Money

class Lotto(val numbers: LottoNumbers) {
    fun countMatchedBy(winningNumbers: LottoNumbers): Int {
        return numbers.countIntersection(winningNumbers)
    }

    companion object {
        val PRICE = Money(1000)
    }
}
