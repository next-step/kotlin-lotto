package lotto.domain

@JvmInline
value class Lottos(val value: List<Lotto>) {
    fun getList(): List<List<Int>> {
        return value.map { it.getLottoNumbers() }
    }
}
