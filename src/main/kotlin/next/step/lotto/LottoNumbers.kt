package next.step.lotto

data class LottoNumbers(val numbers: List<LottoNumber>) : List<LottoNumber> by numbers {

    init {
        require(numbers.size == 6) { "로또 번호들은 6개만 생성할 수 있습니다." }
    }

    companion object {
        fun of(numbers: List<LottoNumber>): LottoNumbers {
            return LottoNumbers(numbers)
        }
    }

}