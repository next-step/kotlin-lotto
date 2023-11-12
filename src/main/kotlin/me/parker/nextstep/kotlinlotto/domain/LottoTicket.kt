package me.parker.nextstep.kotlinlotto.domain

class LottoTicket(val lottoNumbers: LottoNumbers) {

    fun match(winningLottoTicket: LottoTicket): LottoRank {
        val matchCount = lottoNumbers.values.intersect(winningLottoTicket.lottoNumbers.values.toSet()).size

        return LottoRank.of(matchCount, false)
    }

    override fun toString(): String {
        return "LottoTicket(lottoNumbers=$lottoNumbers)"
    }

    companion object {

        const val PRICE: Int = 1_000
        private const val LOTTO_NUMBER_SIZE = 6

        fun automatic(): LottoTicket {
            val lottoNumbers = LottoNumbers()
            while (lottoNumbers.values.size < LOTTO_NUMBER_SIZE) {
                lottoNumbers.add(LottoNumber(RandomLottoNumberGenerationRule()))
            }

            return LottoTicket(lottoNumbers)
        }

        fun manual(numbers: List<Int>): LottoTicket {
            require(numbers.size == LOTTO_NUMBER_SIZE) { "로또 번호는 ${LOTTO_NUMBER_SIZE}개 까지만 가능합니다." }
            require(numbers.toSet().size == LOTTO_NUMBER_SIZE) { "로또 번호는 중복되지 않아야 합니다." }

            val lottoNumbers = LottoNumbers()
            for (number in numbers) {
                lottoNumbers.add(LottoNumber(ManualLottoNumberGenerationRule(number)))
            }

            return LottoTicket(lottoNumbers)
        }

    }
}
