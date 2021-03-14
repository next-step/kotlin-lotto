package lotto.domain.strategy

class OneToSixStrategy : NumberGenerateStrategy {
    override fun generate(): Int {
        return (1..6).random()
    }
}
