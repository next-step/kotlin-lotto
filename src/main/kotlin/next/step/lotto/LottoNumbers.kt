package next.step.lotto

data class LottoNumbers(val numbers: Set<LottoNumber>) : Set<LottoNumber> by numbers {

    init {
        require(numbers.size == 6) { "로또 번호들은 6개만 생성할 수 있습니다." }
    }

    companion object {
        fun of(numbers: Set<LottoNumber>): LottoNumbers {
            return LottoNumbers(numbers)
        }

        fun random() {

        }
    }

}