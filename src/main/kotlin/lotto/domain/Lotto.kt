package lotto.domain

data class Lotto(val lottoNumbers: LottoNumbers) {
    override fun toString(): String {
        return "$lottoNumbers"
    }

    companion object {
        fun auto(): Lotto {
            return Lotto(LottoNumbers.create())
        }

        fun manual(lottoNumbers: LottoNumbers): Lotto {
            return Lotto(lottoNumbers)
        }
    }
}
