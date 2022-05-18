package lotto.model.data

class Policy645 : Policy {
    override val rangeOfNumbers = 1..45
    override val countOfNumberToSelect = 6
    override val priceOfLotto = 1_000
    override val limitAmountToPurchase = 100_000
}
