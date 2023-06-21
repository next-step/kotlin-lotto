package lotto

interface LottoStore<T> {
    fun purchase(count: Int): T
}
