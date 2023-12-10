package lotto.vo

object ManualLotto {
    val lottos: MutableList<Lotto> = mutableListOf()
    private const val LOTTO_NUMBER_COUNT = 6

    fun initLottoNumbers(input: String): ManualLotto {
        val numbers = input.split(",").map { it.trim() }
        require(numbers.size == LOTTO_NUMBER_COUNT) { "로또 번호는 6개여야 합니다." }
        val lottoNumbers = LottoNumber.of(numbers)
        return addLottoNumbers(lottoNumbers)
    }

    fun addLottoNumbers(numbers: List<LottoNumber>): ManualLotto {
        lottos.add(Lotto(numbers))
        return this
    }
}
