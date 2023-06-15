package lotto

interface LottoStore {
    fun purchase(count: Int): List<Lotto>
    fun makeLotto(): Lotto
}
