package lotto.domain

class Lottery(val numbers: Numbers = Numbers()) {
    companion object {
        val ONE_LOTTERY_PRICE = Money(1000)
    }
}
