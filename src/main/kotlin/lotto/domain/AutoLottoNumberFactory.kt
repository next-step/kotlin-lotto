package lotto.domain

class AutoLottoNumberFactory : LottoNumberFactory {
    override fun createLottoNumberList(count: Int): List<LottoNumber> {
        val lottoNumbers = mutableListOf<LottoNumber>()
        val randomNumbers = Lotto.allNumber.shuffled().subList(0, 6).sorted()
        repeat(count) {
            lottoNumbers.add(LottoNumber(randomNumbers))
        }
        return lottoNumbers
    }
}
