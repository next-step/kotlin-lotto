package lotto.model

class LottoNumberPool {
    fun getLottoNumbers(): List<Int> {
        return pool.shuffled().subList(INDEX_FIRST_INCLUSIVE, INDEX_LAST_EXCLUSIVE).sorted()
    }

    companion object {
        private const val MIN = 1
        private const val MAX = 45
        private const val INDEX_FIRST_INCLUSIVE = 0
        private const val INDEX_LAST_EXCLUSIVE = 6

        private val pool = (MIN..MAX).toSet()
    }
}
