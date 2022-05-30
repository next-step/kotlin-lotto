package lotto.domain

class Payment(val cash: Int) {
    init {
        require(cash >= 1000)
    }
}
