package lotto

interface LottoStore<T, V> {
    fun purchase(count: Int): List<Lotto<*, *>>
    fun makeLotto(): Lotto<*, *>
}
