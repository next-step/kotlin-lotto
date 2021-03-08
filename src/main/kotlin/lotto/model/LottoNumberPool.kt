package lotto.model

object LottoNumberPool {
    private const val MIN = 1
    private const val MAX = 45
    private const val INDEX_FIRST_INCLUSIVE = 0
    private const val INDEX_LAST_EXCLUSIVE = 6
    private val NUMBER_POOL = (MIN..MAX).toSet()

    fun getOneLotto(): Lotto {
        return Lotto(getSixNumbers())
    }

    private fun getSixNumbers(): List<Int> {
        return NUMBER_POOL.shuffled().subList(INDEX_FIRST_INCLUSIVE, INDEX_LAST_EXCLUSIVE)
            .sorted()
    }
}
