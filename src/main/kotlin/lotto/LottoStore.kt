package lotto

interface LottoStore<T, V> {
    fun purchase(purchases: T): V
}
