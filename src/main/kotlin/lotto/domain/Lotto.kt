package lotto.domain

data class Lotto(val lottoNumbers: LottoNumbers) {
    override fun toString(): String {
        return "$lottoNumbers"
    }

    companion object {
        fun create(): Lotto {
            return Lotto(LottoNumbers.create())
        }
    }
}
