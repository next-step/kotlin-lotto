package lotto.domain

data class LottoHit(val hits: Int) {
    operator fun compareTo(other: LottoHit): Int = compareValuesBy(this, other, LottoHit::hits)

    override fun toString(): String = "$hits"
}
