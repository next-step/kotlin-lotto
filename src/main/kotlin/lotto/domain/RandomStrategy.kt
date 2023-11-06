package lotto.domain

class RandomStrategy : CreateStrategy {
    override fun createNumbers(): LottoNumbers {
        val list = (1..49).shuffled().take(6).sorted()
        return LottoNumbers(*list.toIntArray())
    }
}
