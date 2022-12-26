package lotto.domain

class LottoMachine {

    fun generate(): LottoTicket {
        val lottoNumbers = mutableSetOf<LottoNumber>()

        while (lottoNumbers.size != LOTTO_NUMBER_SIZE_BOUND) {
            lottoNumbers.add(
                element = LottoNumber.generateRandomNumber()
            )
        }

        return LottoTicket(
            numbers = sorted(lottoNumbers)
        )
    }

    private fun sorted(lottoNumbers: MutableSet<LottoNumber>): Set<LottoNumber> {
        return lottoNumbers
            .sortedBy { it.number }
            .toSet()
    }

    companion object {
        private const val LOTTO_NUMBER_SIZE_BOUND = 6
    }
}
