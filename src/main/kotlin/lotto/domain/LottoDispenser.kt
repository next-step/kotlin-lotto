package lotto.domain

object LottoDispenser {
    fun auto(): Lotto {
        return Lotto(LottoNumber.random(6))
    }
    fun manual(lottoNumbers: List<LottoNumber>): Lotto {
        val distinct = lottoNumbers.distinct()
        require(distinct.size == 6) { "로또 번호는 총 6개가 입력 되어야 합니다." }
        return Lotto(distinct)
    }
}
