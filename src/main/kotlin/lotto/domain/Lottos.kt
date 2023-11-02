package lotto.domain

@JvmInline
value class Lottos(val lottos: List<Lotto>) {

    fun getLottoCount(): Int {
        return lottos.size
    }
}
