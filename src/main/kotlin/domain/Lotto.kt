package domain

class Lotto(val lotto: Set<LottoNumber>) {
    init {
        require(lotto.size == 6) { "로또번호는 중복 없는 6자리 숫자여야합니다." }
    }

    fun matchCount(lotto: Lotto): Int {
        return this.lotto.intersect(lotto.lotto).size
    }

    fun isContain(lottoNumber: LottoNumber): Boolean {
        return this.lotto.contains(lottoNumber)
    }
}
