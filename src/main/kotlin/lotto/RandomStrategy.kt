package lotto

class RandomStrategy : CreateStrategy {
    override fun createNumbers(): List<Int> {
        return (1..49).shuffled().take(6).sorted()
    }
}
