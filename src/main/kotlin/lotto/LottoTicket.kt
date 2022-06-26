package lotto

@JvmInline
value class LottoTicket(val lottoNumbers: Set<LottoNumber>) {
    init {
        require(this.lottoNumbers.size == LOTTO_NUMBERS_SIZE) {
            "로또 티켓은 중복되지 않은 6자리의 숫자들만 가질 수 있습니다. size: ${this.lottoNumbers.size}"
        }
    }

    fun matchNumbers(target: LottoTicket): Int {
        return this.lottoNumbers.count() { it in target }
    }

    operator fun contains(lottoNumber: LottoNumber): Boolean {
        return this.lottoNumbers.contains(lottoNumber)
    }

    companion object {
        const val LOTTO_NUMBERS_SIZE = 6
    }
}
