package lotto.agency.number

interface LottoNumberStrategy {
    fun makeLottoNumbers(): Set<Int>
}
